package com.example.a.warehouseassistant;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteProductFragment extends Fragment {
    private EditText TxtProductId;
    private Button deleteButton;

    public DeleteProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_product, container, false);
        TxtProductId=view.findViewById(R.id.txt_delete_id);
        deleteButton=view.findViewById(R.id.delete);


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int barcodeID= Integer.parseInt(TxtProductId.getText().toString());
                Stock stock = new Stock();
                stock.setBarcodeProduct(barcodeID);
                ManageDB.myAppDatabase.dao().deleteProduct(stock);

                Toast.makeText(getActivity(),"Produkt poprawnie usuniety",Toast.LENGTH_SHORT).show();
                TxtProductId.setText("");
            }
        });
        return view;
    }

}
