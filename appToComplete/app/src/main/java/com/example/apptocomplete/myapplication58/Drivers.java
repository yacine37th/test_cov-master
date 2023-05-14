package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptocomplete.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Drivers extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    Button start_intent ,start12 ,start;
    BottomNavigationView bottomNavigationView3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);


        start_intent=(Button)findViewById(R.id.b_intent);
        Intent intent = new Intent(Drivers.this,MainActivity.class);
        start_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        start12=(Button)findViewById(R.id.coli);
        Intent intent2 = new Intent(Drivers.this,Something.class);
       start12.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(intent2);
           }
       });
        start=(Button)findViewById(R.id.covo);
        Intent intent1 = new Intent(Drivers.this,People.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });




        //bottonbar
        bottomNavigationView3 = (BottomNavigationView) findViewById(R.id.navigation1);
        bottomNavigationView3.setOnNavigationItemSelectedListener(this);
        bottomNavigationView3.setSelectedItemId(R.id.home1);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.discount1:
                startActivity(new Intent(getApplicationContext(), Descount1.class));
                finish();
                overridePendingTransition(0, 0);


                return true;


            case R.id.help1:
                startActivity(new Intent(getApplicationContext(), Help1.class));
                finish();
                overridePendingTransition(0, 0);


                return true;


            case R.id.profile1:
                startActivity(new Intent(getApplicationContext(), Profile1.class));
                finish();
                overridePendingTransition(0, 0);


                return true;


            case R.id.Dravers:
                return true;


        }
        return false;


    }
    }