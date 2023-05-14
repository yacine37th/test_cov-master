package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apptocomplete.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login_phone_customers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_customers);
        final EditText inputMobile1 = findViewById(R.id.inputMobile1);
        Button buttonGetOTP1 = findViewById(R.id.buttonGetOTP1);
        final ProgressBar progressBar1 =findViewById(R.id.progressBar1);



        buttonGetOTP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputMobile1.getText().toString().trim().isEmpty()){
                    Toast.makeText(Login_phone_customers.this,"Enter Mobile",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar1.setVisibility(View.VISIBLE);
                buttonGetOTP1.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+213"+ inputMobile1.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        Login_phone_customers.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar1.setVisibility(View.GONE);
                                buttonGetOTP1.setVisibility(View.VISIBLE);
                                Toast.makeText(Login_phone_customers.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar1.setVisibility(View.GONE);
                                buttonGetOTP1.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(),verifyOTPActivity1.class);
                                intent.putExtra("mobile",inputMobile1.getText().toString());
                                intent.putExtra("verificationID",verificationID);
                                startActivity(intent);
                            }
                        }

                );



            }
        });
    }
}