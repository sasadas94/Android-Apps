package com.example.a.warehouseassistant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadProductFragment extends Fragment {
    private TextView txtinfo;


    public ReadProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_product, container, false);

        txtinfo=view.findViewById(R.id.txt_display_info);

        ArrayList<Stock> stock = (ArrayList<Stock>) ManageDB.myAppDatabase.dao().getStock();
        String info="";
        for(Stock stockk: stock){
            long bc=stockk.getBarcodeProduct();
            long cd=stockk.getBarcodeShelf();
            int qn=stockk.getQuantity();
            String nm=stockk.getName();

             info= info+"Kod kreskowy produktu: "+bc+"\n"+"Kod kreskowy półki: "+cd+"\n"+"Nazwa produktu: "+nm+"\n"+"Ilość produktu: "+qn+"\n\n";




        }

        txtinfo.setText(info);
        return view;
    }

}
