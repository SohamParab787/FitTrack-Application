package com.example.fittrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;

public class exercise_layout extends AppCompatActivity
{
    private Button beginer_button;
    private Button intermediate_button;
    private Button advance_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_layout);

        beginer_button = findViewById(R.id.beginer_button);
        intermediate_button = findViewById(R.id.intermediate_button);
        advance_button = findViewById(R.id.advance_button);

        Intent intent = getIntent();

        beginer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                short sb=1;
                Intent intent1 = new Intent(v.getContext(), beginner_exercise_layout.class);
                intent1.putExtra("Selected button",sb);
                startActivity(intent1);
            }
        });

        intermediate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                short sb=2;
                Intent intent1 = new Intent(v.getContext(), intermediate_exercise_layout.class);
                intent1.putExtra("Selected button",sb);
                startActivity(intent1);
            }
        });

        advance_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                short sb=3;
                Intent intent1 = new Intent(v.getContext(), advance_exercise_layout.class);
                intent1.putExtra("Selected button",sb);
                startActivity(intent1);
            }
        });

    }
}
