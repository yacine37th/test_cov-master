package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.apptocomplete.R;

public class Activity_Facebook extends AppCompatActivity {
ImageView ivWhatsApp,ivFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        ivWhatsApp = findViewById(R.id.iv_wats_app);
        ivFacebook = findViewById(R.id.iv_facebook);
       ivWhatsApp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String sNumber = "+0658068810";
               Uri uri=Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s",sNumber));
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(uri);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
           }
       });
       ivFacebook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String sAppLink ="fb://page/100090925556892";
               String sPackage = "com.facebook.katana";
               String sWebLink = "https://www.facebook.com/12H1rDeveloper";
               openLink(sAppLink,sPackage,sWebLink);
           }

           private void openLink(String sAppLink, String sPackage, String sWebLink) {
               try {
                   Uri uri = Uri.parse(sAppLink);
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setData(uri);
                   intent.setPackage(sPackage);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   startActivity(intent);
               }catch (ActivityNotFoundException activityNotFoundException){
                   Uri uri = Uri.parse(sWebLink);
                   Intent intent =new Intent(Intent.ACTION_VIEW);
                   intent.setData(uri);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   startActivity(intent);
               }
           }
       });
    }
}