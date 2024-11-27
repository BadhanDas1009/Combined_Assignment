package com.example.combined_app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Assignment4 extends AppCompatActivity {

    ListView customListView;
    ArrayList<ListItem> itemList;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment4);

        customListView = findViewById(R.id.customListView);

        // Populate the list with professions
        itemList = new ArrayList<>();
        itemList.add(new ListItem(R.drawable.doctor, "Doctor", "Medical professionals who save lives."));
        itemList.add(new ListItem(R.drawable.engineer, "Engineer", "Designers of technology and infrastructure."));
        itemList.add(new ListItem(R.drawable.teacher, "Teacher", "Educators who shape future generations."));
        itemList.add(new ListItem(R.drawable.chef, "Chef", "Masters of culinary arts."));
        itemList.add(new ListItem(R.drawable.pilot, "Pilot", "Navigators of the skies."));

        // Set adapter
        adapter = new CustomListAdapter(this, itemList);
        customListView.setAdapter(adapter);
    }
}
