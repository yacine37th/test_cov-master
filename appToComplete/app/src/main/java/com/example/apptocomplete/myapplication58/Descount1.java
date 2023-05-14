package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.apptocomplete.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.regex.Pattern;

public class Descount1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    EditText Code ;
    Button buttoncode , btn ;
    BottomNavigationView bottomNavigationView4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descount1);



        Code = findViewById(R.id.Code);
        buttoncode = findViewById(R.id.buttoncode);
        buttoncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateCodeAddress
                        (Code);

            }
        });






        bottomNavigationView4 = (BottomNavigationView) findViewById(R.id.navigation1);
        bottomNavigationView4.setOnNavigationItemSelectedListener(this);

        bottomNavigationView4.setSelectedItemId(R.id.discount1);



    }








    private  boolean ValidateCodeAddress(EditText Code){
        String codeInput =Code.getText().toString();
        if (!codeInput.isEmpty());
        Toast.makeText(this, "Invalid Code", Toast.LENGTH_SHORT).show();
        btn=findViewById(R.id.buttoncode);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notification","Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Descount1.this,"Notification");
                builder.setContentTitle("there is a problem");
                builder.setContentText("The discounts service is still under construction");
                builder.setSmallIcon(R.drawable.facebook_app_symbol13);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat =NotificationManagerCompat.from(Descount1.this);
                managerCompat.notify(1,builder.build());
            }
        });
        return false ;
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
            case R.id.discount1:
                return true;
        }
        return false;
    }}