package com.example.combined_app;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assignment5 extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupList;
    HashMap<String, List<String>> childMap;
    CustomExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment5);

        expandableListView = findViewById(R.id.expandableListView);

        // Populate data
        prepareData();

        // Set adapter
        adapter = new CustomExpandableListAdapter(this, groupList, childMap);
        expandableListView.setAdapter(adapter);
    }

    private void prepareData() {
        groupList = new ArrayList<>();
        childMap = new HashMap<>();

        // Add groups (categories)
        groupList.add("Tropical Fruits");
        groupList.add("Citrus Fruits");
        groupList.add("Berries");

        // Add children (examples) for each category
        List<String> tropicalFruits = new ArrayList<>();
        tropicalFruits.add("Mango");
        tropicalFruits.add("Pineapple");
        tropicalFruits.add("Papaya");

        List<String> citrusFruits = new ArrayList<>();
        citrusFruits.add("Orange");
        citrusFruits.add("Lemon");
        citrusFruits.add("Grapefruit");

        List<String> berries = new ArrayList<>();
        berries.add("Strawberry");
        berries.add("Blueberry");
        berries.add("Raspberry");

        childMap.put(groupList.get(0), tropicalFruits);
        childMap.put(groupList.get(1), citrusFruits);
        childMap.put(groupList.get(2), berries);
    }
}
