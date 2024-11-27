package com.example.combined_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Assignment6 extends AppCompatActivity {

    RecyclerView recyclerView;
    FruitAdapter fruitAdapter;
    ArrayList<Fruit> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment6);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Apple", R.drawable.apple));
        fruitList.add(new Fruit("Banana", R.drawable.banana));
        fruitList.add(new Fruit("Orange", R.drawable.orange));
        fruitList.add(new Fruit("Grapes", R.drawable.grapes));

        fruitAdapter = new FruitAdapter(fruitList, new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit) {
                // Handle item click
                Toast.makeText(Assignment6.this, "You selected: " + fruit.getName(), Toast.LENGTH_SHORT).show();
                // You can start a new activity or display more info here
            }
        });

        recyclerView.setAdapter(fruitAdapter);
    }
}
