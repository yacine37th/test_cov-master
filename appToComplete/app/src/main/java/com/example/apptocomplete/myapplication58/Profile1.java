package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.apptocomplete.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
        bottomNavigationView6 = (BottomNavigationView) findViewById(R.id.navigation1);
        bottomNavigationView6.setOnNavigationItemSelectedListener(this);
        bottomNavigationView6.setSelectedItemId(R.id.profile1);



    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.home1:
                startActivity(new Intent(getApplicationContext(), Drivers.class));
                finish();
                overridePendingTransition(0, 0);
                return true;
            case R.id.discount1:
                startActivity(new Intent(getApplicationContext(), Descount1.class));
                finish();
                overridePendingTransition(0, 0);
                return true;
            case R.id.help1:
                startActivity(new Intent(getApplicationContext(), Help1.class));
                finish();
                overridePendingTransition(0, 0);
            case R.id.profile1:
                return true ;
        }
        return false;
}}