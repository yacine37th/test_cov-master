package com.example.apptocomplete.myapplication58;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apptocomplete.R;

import java.util.ArrayList;

public class PersonAdapter00 extends ArrayAdapter<Person00> {
    private Context mContext ;
    private int mResource ;
    public PersonAdapter00(@NonNull Context context, int resource, @NonNull ArrayList<Person00> objects) {
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
        ImageView imageView =convertView.findViewById(R.id.image);
        TextView txtName =convertView.findViewById(R.id.txtName);
        TextView txtDes =convertView.findViewById(R.id.txrDes);
        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());

        return convertView ;
    }
}
