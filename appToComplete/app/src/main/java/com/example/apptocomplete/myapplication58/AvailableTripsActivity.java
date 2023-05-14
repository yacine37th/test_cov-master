package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.apptocomplete.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapters.TripsAdapter;
import classes.Trip;

public class AvailableTripsActivity extends AppCompatActivity {


    FirebaseDatabase database ;
    DatabaseReference tripsRef;
    ArrayList<Trip> trips;
    RecyclerView list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_trips);
        init();
        tripsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                trips.clear();
                for (DataSnapshot oneSnap:
                     snapshot.getChildren()) {
                    trips.add(oneSnap.getValue(Trip.class));
                }
                TripsAdapter adapter = new TripsAdapter(trips , AvailableTripsActivity.this);
                LinearLayoutManager manager = new LinearLayoutManager(AvailableTripsActivity.this);
                list.setLayoutManager(manager);
                list.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void init(){
        database = FirebaseDatabase.getInstance(getString(R.string.DB_url));
        tripsRef = database.getReference().child("TripsAvailable");
        trips = new ArrayList<>();
        list = findViewById(R.id.tripList);
    }
}