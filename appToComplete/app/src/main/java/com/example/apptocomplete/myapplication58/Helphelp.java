package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.apptocomplete.R;

import java.util.ArrayList;

public class Helphelp extends AppCompatActivity {
    ListView listView1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helphelp);
        listView1  = findViewById(R.id.listView13);
        //Create data
        ArrayList<Person1>arrayList1 =new ArrayList<>();
        arrayList1.add(new Person1("How to apply for a RanaHna","You just need to install the application, register by putting your personal information and then enter your starting point and your destination The number of people and specify the type of transmission","fftrrf"));
        arrayList1.add(new Person1("Is it possible to have an invoice for my race to justify my trips?","Yes, you can request an invoice at the end of the race via the application, which you will receive by email.","fftrrf"));
        arrayList1.add(new Person1("How to get a code promo?","Promo codes are systematically published on our official Facebook pages, and sent through in-app notifications","fftrrf"));
        arrayList1.add(new Person1("Is your service available every weekday and even at night?","Yes, our driver-partners are available 24 hours a day, 7 days a week, you can make a request at any time of the day.","fftrrf"));
        arrayList1.add(new Person1("Can I choose between a female or male driver?","Unfortunately this option is not yet available on the application, but it will be very soon!","fftrrf"));

        //we make custom adapter
     PersonAdapter1 personAdapter1 = new PersonAdapter1(this,R.layout.list_row1,arrayList1);
     listView1.setAdapter(personAdapter1);


    }
}