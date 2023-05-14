package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptocomplete.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Help1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    BottomNavigationView bottomNavigationView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help1);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent= new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0658068810"));
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Activity_Facebook.class);
                    startActivity(intent);
                }


                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Helphelp.class);
                    startActivity(intent);
                }
            }
        });






        //create data
        ArrayList<person> arrayList = new ArrayList<>();
        arrayList.add(new person(R.drawable.facebook_app_symbol13, "Helpline", "Available 24/24 hours", "Helpline1"));
        arrayList.add(new person(R.drawable.facebook_app_symbol13, "Going on Facebook and WatsApp", "Join our community on Facebook", "Facebook1"));
        arrayList.add(new person(R.drawable.facebook_app_symbol13, "Common Questions", "Find answers to your questions", "Question1"));

        //we make custom adapter
        personAdapter personAdapter = new personAdapter(this, R.layout.list_row, arrayList);
        listView.setAdapter(personAdapter);


        bottomNavigationView5 = (BottomNavigationView) findViewById(R.id.navigation1);
        bottomNavigationView5.setOnNavigationItemSelectedListener(this);
        bottomNavigationView5.setSelectedItemId(R.id.help1);


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


            case R.id.profile1:
                startActivity(new Intent(getApplicationContext(), Profile1.class));
                finish();
                overridePendingTransition(0, 0);


                return true;

            case R.id.help1:
                return true;


        }
        return false;

    }
}
