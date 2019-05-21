package com.example.a.warehouseassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView etUsername = (TextView) findViewById(R.id.etPassword);

        Intent intent = getIntent();
        String username = intent.getStringExtra("name");

        etUsername.setText(username);
    }

    public void onScannerClick(View v) {
        if (v.getId() == R.id.button) {
            Intent i = new Intent(UserAreaActivity.this, ScannerProduct.class);
            startActivity(i);
        }
    }
        public void onMagazynClick(View view){
            if(view.getId()== R.id.button3){
                Intent i = new Intent(UserAreaActivity.this, ManageDB.class);
                startActivity(i);
            }
        }
    }

