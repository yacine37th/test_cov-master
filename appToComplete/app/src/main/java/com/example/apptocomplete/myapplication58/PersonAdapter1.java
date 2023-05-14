package com.example.apptocomplete.myapplication58;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apptocomplete.R;

import java.util.ArrayList;

public class PersonAdapter1 extends ArrayAdapter<Person1> {
    private Context mContext ;
    private int mResource ;
    public PersonAdapter1(@NonNull Context context, int resource, @NonNull ArrayList<Person1> objects) {
        super(context, resource, objects);
        this.mContext = context ;
        this.mResource =resource ;
        this.mResource =resource ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater1 =LayoutInflater.from(mContext);
        convertView =layoutInflater1.inflate(mResource,parent,false);
        TextView txtName =convertView.findViewById(R.id.txtName1);
        TextView txtDes =convertView.findViewById(R.id.txrDes1);
       txtName.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());
        return convertView;
    }
}
