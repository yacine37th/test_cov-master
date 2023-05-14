package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptocomplete.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classes.Trip;

public class Customers extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    EditText departEdit , destinationEdit , priceEdit , conditionEdit ;
    FirebaseDatabase database ;
    DatabaseReference tripsRef;
    Button addTripBtn;
    ProgressDialog dialog ;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        init();
        addTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkFields()){
                    dialog.show();
                    String id  = tripsRef.push().getKey();
                    Trip trip = new Trip(mAuth.getCurrentUser().getUid() ,id ,  departEdit.getText().toString() , destinationEdit.getText().toString() , Integer.valueOf(priceEdit.getText().toString()) , conditionEdit.getText().toString() );
                    tripsRef.child(id).setValue(trip).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Customers.this, "trip added", Toast.LENGTH_SHORT).show();
                                clearFields();
                            } else {
                                Toast.makeText(Customers.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog.dismiss();
                } else {
                    Toast.makeText(Customers.this, "please enter all information's " , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.help:
                startActivity(new Intent(getApplicationContext(),Help.class));
                finish();
                overridePendingTransition(0,0);
                return true ;
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(),Profile.class));
                finish();
                overridePendingTransition(0,0);
                return true ;
            case R.id.Customers:
                return true ;
        }
        return false;
    }

    private void init(){
            departEdit = findViewById(R.id.departEdit);
            destinationEdit = findViewById(R.id.destinationEdit);
            priceEdit = findViewById(R.id.priceEdit);
            conditionEdit = findViewById(R.id.conditionEdit);
            database = FirebaseDatabase.getInstance(getString(R.string.DB_url));
            tripsRef = database.getReference().child("TripsAvailable");
        addTripBtn = findViewById(R.id.addTripBtn);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait while adding your trip !");
        dialog.setTitle("Adding Trip");
        mAuth = FirebaseAuth.getInstance();
    }

    private boolean checkFields(){
        if (departEdit.getText().toString().isEmpty()){
            return false;
        } else if ( destinationEdit.getText().toString().isEmpty()){
            return false;
        } else if ( priceEdit.getText().toString().isEmpty()){
            return false;
        } else
            return true;
    }
    private void clearFields(){
        departEdit.setText("");
        destinationEdit.setText("");
        priceEdit.setText("");
        conditionEdit.setText("");
        Intent i = new Intent(Customers.this , AvailableTripsActivity.class);
        startActivity(i);
    }
}