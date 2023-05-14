package com.example.apptocomplete.myapplication58;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptocomplete.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verifyOTPActivity1 extends AppCompatActivity {
    private EditText inputCode1,inputCode2,inputCode3,inputCode4,inputCode5,inputCode6;
    private String verificationID1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otpactivity1);
        TextView textMobile1 = findViewById(R.id.textMobile1);
        textMobile1.setText(String.format(
                "+213-%s",getIntent().getStringExtra("mobile")
        ));

        inputCode1 =findViewById(R.id.inputCode1);
        inputCode2 =findViewById(R.id.inputCode2);
        inputCode3 =findViewById(R.id.inputCode3);
        inputCode4 =findViewById(R.id.inputCode4);
        inputCode5 =findViewById(R.id.inputCode5);
        inputCode6 =findViewById(R.id.inputCode6);
        setupOTPInputs();
        final ProgressBar progressBar1= findViewById(R.id.progressBar1);
        final Button buttonVerify1 = findViewById(R.id.buttonVerify1);

        verificationID1=getIntent().getStringExtra("verificationID");
        buttonVerify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputCode1.getText().toString().trim().isEmpty()
                        ||inputCode2.getText().toString().trim().isEmpty()
                        ||inputCode3.getText().toString().trim().isEmpty()
                        ||inputCode4.getText().toString().trim().isEmpty()
                        ||inputCode5.getText().toString().trim().isEmpty()
                        ||inputCode6.getText().toString().trim().isEmpty()){
                    Toast.makeText(verifyOTPActivity1.this, "Please enter valid code", Toast.LENGTH_SHORT).show();
                    return;
                }
                String code =
                        inputCode1.getText().toString()+
                                inputCode2.getText().toString()+
                                inputCode3.getText().toString()+
                                inputCode4.getText().toString()+
                                inputCode5.getText().toString()+
                                inputCode6.getText().toString();
                if (verificationID1 != null){
                    progressBar1.setVisibility(View.VISIBLE);
                    buttonVerify1.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(
                            verificationID1,
                            code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar1.setVisibility(View.GONE);
                                    buttonVerify1.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(getApplicationContext(),Customers.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(verifyOTPActivity1.this,"The verification code entered was invalid",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });
        findViewById(R.id.textResendOTP1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+213"+ getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        verifyOTPActivity1.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(verifyOTPActivity1.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newverificationID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                verificationID1 = newverificationID;
                                Toast.makeText(verifyOTPActivity1.this,"OTP sent",Toast.LENGTH_SHORT).show();
                            }
                        }

                );
            }
        });
    }
    private void setupOTPInputs() {
        inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    inputCode2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    inputCode3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    inputCode4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    inputCode5.requestFocus();
                }

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    inputCode6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}