package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.apptocomplete.R;

import java.util.ArrayList;

public class Helphelp1 extends AppCompatActivity {
    ListView listView1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helphelp1);
        listView1  = findViewById(R.id.listView107);
        //Create data
        ArrayList<Person1> arrayList1 =new ArrayList<>();
        arrayList1.add(new Person1("How to join RanaHna ?","It's simple, you just have to go to the RanaHna headquarters, you will fill in an information sheet, and our RanaHna recruitment manager will give you an appointment to attend a training session.","fftrrf"));
        arrayList1.add(new Person1("How can I contact you?","You can reach us via customer service 24/7 on 0658068810. And also via Messenger and Facebook. We will be happy to answer you !","fftrrf"));
        arrayList1.add(new Person1("How long does the formation?","You should know that the training takes practically the whole morning, minimum 03 hours between the theoretical training and the validation of the file, as well as the installation of the application and finalizing the process.","fftrrf"));
        arrayList1.add(new Person1("Do I have to show up with my vehicle?","The day you go to the RanaHna headquarters, it is very important to show up with your vehicle so that our technician can carry out a check.","fftrrf"));
        arrayList1.add(new Person1("What are the places with strong asked ?","Where there are RanaHna customers, there is demand! It is up to you to ensure good service delivery. A satisfied customer is the best business strategy.","fftrrf"));
        arrayList1.add(new Person1("What time of day do I can work?","Choose a schedule and adapt it to your family and social life, but you can work 24/7, because the more you work, the more you will increase your earnings.","fftrrf"));

        //we make custom adapter
        PersonAdapter1 personAdapter1 = new PersonAdapter1(this,R.layout.list_row1,arrayList1);
        listView1.setAdapter(personAdapter1);

    }
}