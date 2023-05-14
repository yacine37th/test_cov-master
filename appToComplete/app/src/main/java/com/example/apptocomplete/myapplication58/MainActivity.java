package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apptocomplete.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button mDraver , mCustomers ;
    private FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth= FirebaseAuth.getInstance();
        mDraver =(Button) findViewById(R.id.Dravers);
        mCustomers =(Button) findViewById(R.id.Customers);
        mDraver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mAuth.getCurrentUser() != null){
                   Intent intent = new Intent(MainActivity.this , Drivers.class);
                   startActivity(intent);
               }else {
                   Intent intent = new Intent(MainActivity.this , DraverLoginActivity.class);
                   startActivity(intent);
                   finish();
               }
            }
        });
        mCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() != null){
                    Intent intent = new Intent(MainActivity.this , Customers.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, Customerslohinactivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}