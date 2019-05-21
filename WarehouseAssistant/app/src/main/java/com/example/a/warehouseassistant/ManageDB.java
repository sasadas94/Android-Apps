package com.example.a.warehouseassistant;


import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ManageDB extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;
    public static Database myAppDatabase;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_db);
        fragmentManager=getSupportFragmentManager();
        floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),Database.class,"productdb").allowMainThreadQueries().build();


        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new ReadProductFragment()).commit();
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageDB.fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();
            }
        });

    }

}
