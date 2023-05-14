package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.apptocomplete.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
BottomNavigationView bottomNavigationView1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView1 = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView1.setOnNavigationItemSelectedListener(this);
        bottomNavigationView1.setSelectedItemId(R.id.profile);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home:
                startActivity(new Intent(getApplicationContext(),Customers.class));
                finish();
                overridePendingTransition(0,0);
                return true;




            case R.id.help:
                startActivity(new Intent(getApplicationContext(),Help.class));
                finish();
                overridePendingTransition(0,0);


                return true ;








            case R.id.profile:
                return true ;










        }
        return false;







    }
}