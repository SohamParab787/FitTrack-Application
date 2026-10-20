package com.example.fittrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Button exercise_button;
    private Button drink_button;
    private Button diet_button;
    private Button facts_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        exercise_button = findViewById(R.id.exercise_button);
        drink_button = findViewById(R.id.drink_button);
        diet_button = findViewById(R.id.diet_button);
        facts_button = findViewById(R.id.facts_button);

        exercise_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),exercise_layout.class);
                startActivity(intent);
            }
        });

        drink_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), drink_water_main.class);
                startActivity(intent);
            }
        });

        diet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), diet_layout.class );
                startActivity(intent);
            }
        });

        facts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), facts_layout.class  );
                startActivity(intent);
            }
        });
    }


}