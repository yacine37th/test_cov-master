package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apptocomplete.R;

public class Something extends AppCompatActivity {
    Button btn_typ ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_something);
        btn_typ=(Button)findViewById(R.id.type);
        Intent intent = new Intent(Something.this,Transmmitter_type.class);
        btn_typ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}