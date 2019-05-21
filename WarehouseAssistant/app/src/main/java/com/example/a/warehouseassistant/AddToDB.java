package com.example.a.warehouseassistant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddToDB extends AppCompatActivity {

String kodKreskowyProduktu;
static int ilosc=1;

    EditText kodProduktu;
    Button plus;
    Button minus;
    Button dodajDoMagazynu;
    Button skanujKodPolki;
    EditText nazwa;
    EditText kodPolki;
    TextView quantityTextView;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_db);

        plus=findViewById(R.id.bPlus);
        minus=findViewById(R.id.bMinus);
        dodajDoMagazynu=findViewById(R.id.button5);
        skanujKodPolki=findViewById(R.id.bSkanujKodPolki);
        tv = findViewById(R.id.textView6);
        kodProduktu=findViewById(R.id.editText3);
        nazwa=findViewById(R.id.editText);
        kodPolki=findViewById(R.id.editText7);
        quantityTextView=findViewById(R.id.quantity_text_view);

        dodajDoMagazynu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long Productbarcode =  Long.parseLong((kodProduktu.getText().toString()));

                String nameProduct = nazwa.getText().toString();

                long Shelfbarcode =   Long.parseLong((kodPolki.getText().toString()));

                int quantity = Integer.parseInt((quantityTextView.getText().toString()));

                Stock stock= new Stock();
                stock.setBarcodeProduct(Productbarcode);
                stock.setBarcodeShelf(Shelfbarcode);
                stock.setName(nameProduct);
                stock.setQuantity(quantity);

                ManageDB.myAppDatabase.dao().addProduct(stock);

                Toast.makeText(AddToDB.this,"Dodano do magazynu",Toast.LENGTH_SHORT).show();
                kodProduktu.setText("");
                kodPolki.setText("");
                nazwa.setText("");
                quantityTextView.setText("");

                Intent intent=new Intent(AddToDB.this,UserAreaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilosc++;
                display(ilosc);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ilosc==1){
                    Toast.makeText(AddToDB.this, "Nie możesz dodać mniej niż 1 produkt.", Toast.LENGTH_SHORT).show();
                    return;
                }
                ilosc--;
                display(ilosc);
            }
        });

        Intent intent = getIntent();
        kodKreskowyProduktu = intent.getStringExtra("kodKreskowyProduktu");

        Intent intent1=getIntent();
        String kodKreskowyPolki=intent1.getStringExtra("resultShelf");
        String kodKreskowyProd=intent1.getStringExtra("kodKreskowyP");
        kodPolki.setText(kodKreskowyPolki);

        if (TextUtils.isEmpty(kodKreskowyProd)){
            kodProduktu.setText(kodKreskowyProduktu);
        }else {
            kodProduktu.setText(kodKreskowyProd);
        }

        String GetEditText = kodPolki.getText().toString();
        if(TextUtils.isEmpty(GetEditText)){
            tv.setVisibility(View.INVISIBLE);
        }else {
            tv.setVisibility(View.VISIBLE);
        }
        skanujKodPolki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddToDB.this,ScannerShelf.class);
                intent.putExtra("kodProduktu", String.valueOf(kodKreskowyProduktu));
                startActivity(intent);
            }
        });
        }

    private void display(int number) {
        quantityTextView.setText("" + ilosc);
    }
}
