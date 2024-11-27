package com.example.combined_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   Button assignment_1;
    Button assignment_2;
    Button assignment_3;
    Button assignment_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignment_1 = findViewById(R.id.assignment_1);
        assignment_2 = findViewById(R.id.assgnment_2);
        assignment_3 = findViewById(R.id.assignment_3);
        assignment_4 = findViewById(R.id.assignment_4);

        assignment_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Assignment1.class);
                startActivity(intent);
            }
        });
        assignment_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Assignment2.class);
                startActivity(intent);
            }
        });

        assignment_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Assignment3.class);
                startActivity(intent);
            }
        });
        assignment_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Assignment4.class);
                startActivity(intent);
            }
        });



    }
}