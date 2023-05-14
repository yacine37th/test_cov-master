package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.apptocomplete.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Help extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView2 ;
    ListView listView07 ;
    ListView list1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



        list1  = findViewById(R.id.listView07);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){

                        Intent intent= new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:0658068810"));
                        startActivity(intent);

                }
                if(position ==1){
                    Intent intent =new Intent(view.getContext(),Activity_Facebook.class);
                    startActivity(intent);
                }
                if(position ==2){
                    Intent intent =new Intent(view.getContext(),Helphelp1.class);
                    startActivity(intent);
                }


            }
        });










listView07=findViewById(R.id.listView07);
        //create data
        ArrayList<person> arrayList07 =new ArrayList<>();
        arrayList07.add(new person(R.drawable.facebook_app_symbol13,"Helpline","Available 24/24 hours","Helpline"));
        arrayList07.add(new person(R.drawable.facebook_app_symbol13,"Going on Facebook and WatsApp","Join our community on Facebook","Facebook"));
        arrayList07.add(new person(R.drawable.facebook_app_symbol13,"Common Questions","Find answers to your questions","Question"));

        //we make custom adapter
        personAdapter personAdapter =new personAdapter(this ,R.layout.list_row,arrayList07);
        listView07.setAdapter(personAdapter);




        bottomNavigationView2 = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView2.setOnNavigationItemSelectedListener(this);
        bottomNavigationView2.setSelectedItemId(R.id.help);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.home:
                startActivity(new Intent(getApplicationContext(),Customers.class));
                finish();
                overridePendingTransition(0,0);


                return true ;



            case R.id.profile:
                startActivity(new Intent(getApplicationContext(),Profile.class));
                finish();
                overridePendingTransition(0,0);


                return true ;







            case R.id.help:
                return true;







        }
        return false;



    }
}