package com.example.apptocomplete.myapplication58;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptocomplete.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DraverLoginActivity extends AppCompatActivity {
    TextView textView ;
    private EditText mEmail , mPassword ;
    private Button mLogin , mRegistration ;
    private FirebaseAuth mAuth ;
    private FirebaseAuth.AuthStateListener firebaseauthlistener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_draver_login);
        mAuth = FirebaseAuth.getInstance();

        firebaseauthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(DraverLoginActivity.this,Drivers.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };
        textView=(TextView)findViewById(R.id.txt_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DraverLoginActivity.this,Login_phone_driver.class);
                startActivity(intent);

            }
        });

        mEmail =(EditText) findViewById(R.id.Email);
        mPassword =(EditText) findViewById(R.id.Password);
        mLogin =(Button) findViewById(R.id.Login);
        mRegistration =(Button) findViewById(R.id.Registration);



        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Email = mEmail.getText().toString();
                final String Password = mPassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(Email , Password).addOnCompleteListener(DraverLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(DraverLoginActivity.this ,"Sign up error" , Toast.LENGTH_SHORT).show();
                        }else {
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Driver").child(user_id);
                            current_user_db.setValue(true);
                        }

                    }
                });
                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String Email = mEmail.getText().toString();
                        final String Password = mPassword.getText().toString();
                        mAuth.signInWithEmailAndPassword(Email , Password).addOnCompleteListener(DraverLoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(DraverLoginActivity.this ,"Sign ir error" , Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });


            }
        });

        }










    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseauthlistener);


    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseauthlistener);
    }


}