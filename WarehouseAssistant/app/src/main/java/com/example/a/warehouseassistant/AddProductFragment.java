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
public class AddProductFragment extends Fragment {

    private EditText ProductName,ProductBarcode,ProductQuantity,ShelfBarcode;
    private Button BnSave;

    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        ProductName=view.findViewById(R.id.name_plaintext);
        ProductBarcode=view.findViewById(R.id.barcodeProduct_plaintext);
        ShelfBarcode=view.findViewById(R.id.barcodeShelf_plaintext);
        ProductQuantity=view.findViewById(R.id.quantity_plaintext);
        BnSave= view.findViewById(R.id.add_button);

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long Productbarcode =  Long.parseLong(ProductBarcode.getText().toString());

                String nameProduct = ProductName.getText().toString();

                long Shelfbarcode =   Long.parseLong(ShelfBarcode.getText().toString());

                int quantity = Integer.parseInt(ProductQuantity.getText().toString());


                Stock stock= new Stock();
                stock.setBarcodeProduct(Productbarcode);
                stock.setBarcodeShelf(Shelfbarcode);
                stock.setName(nameProduct);
                stock.setQuantity(quantity);


                ManageDB.myAppDatabase.dao().addProduct(stock);
                Toast.makeText(getActivity(),"Produkt dodany prawidłowo!",Toast.LENGTH_SHORT).show();

                ProductBarcode.setText("");
                ShelfBarcode.setText("");
                ProductName.setText("");
                ProductQuantity.setText("");

            }
        });

        return view;
    }

}
