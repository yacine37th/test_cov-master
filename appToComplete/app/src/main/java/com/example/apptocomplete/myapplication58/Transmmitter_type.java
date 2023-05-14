package com.example.apptocomplete.myapplication58;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apptocomplete.R;

import java.util.ArrayList;

public class Transmmitter_type extends AppCompatActivity {
SearchView searchView ;
RecyclerView recyclerView ;
ArrayList<ModelClass> arrayList = new ArrayList<>();
ArrayList<ModelClass> searchList;
String[] fruitList = new String[]{"Pharmaceutical","Foods","Leaves","Devices","Car components","fragile","réfrigéré"};
String[] fruitNum = new String[]{"Needle,Medicine vial,Medical devices","Vegetables,Fruits","Docs,Files","Phone,Television,Refrigerator","Engine,Glass,Wheels","Home furnishings,Glass","Meat,Canned food,Yogurt"};
int[] imgList= new int[]{R.drawable.medicine,R.drawable.take_away,R.drawable.email,R.drawable.device12,R.drawable.car_engine,R.drawable.fragile,R.drawable.refrigerator};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmmitter_type);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        searchView.setIconified(false);

        for (int i = 0; i < fruitList.length; i++) {
            ModelClass modelClass=new ModelClass();
            modelClass.setFruitName(fruitList[i]);
            modelClass.setFruitNum(fruitNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);

        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Transmmitter_type.this);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter fruitAdapter=new FruitAdapter(Transmmitter_type.this,arrayList);
        recyclerView.setAdapter(fruitAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList=new ArrayList<>();

                if (query.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitName().toUpperCase().contains(query.toUpperCase())||arrayList.get(i).getFruitNum().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setFruitNum(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }

                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Transmmitter_type.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter=new FruitAdapter(Transmmitter_type.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);

                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Transmmitter_type.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter=new FruitAdapter(Transmmitter_type.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList=new ArrayList<>();

                if (newText.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitName().toUpperCase().contains(newText.toUpperCase())||arrayList.get(i).getFruitNum().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setFruitNum(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }

                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Transmmitter_type.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter=new FruitAdapter(Transmmitter_type.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);

                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Transmmitter_type.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter=new FruitAdapter(Transmmitter_type.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                return false;
            }
        });
    }
}