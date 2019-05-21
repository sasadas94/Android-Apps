package com.example.a.warehouseassistant;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnAddProduct,bnReadProduct,bnDeleteProduct;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        bnAddProduct=view.findViewById(R.id.add_product);
        bnAddProduct.setOnClickListener(this);

        bnReadProduct=view.findViewById(R.id.find_product);
        bnReadProduct.setOnClickListener(this);

        bnDeleteProduct=view.findViewById(R.id.delete_product);
        bnDeleteProduct.setOnClickListener(this);




        return view;


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add_product:
                ManageDB.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddProductFragment()).addToBackStack(null).commit();
                break;
            case R.id.find_product:
                ManageDB.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadProductFragment()).addToBackStack(null).commit();
                break;
            case R.id.delete_product:
                ManageDB.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteProductFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
