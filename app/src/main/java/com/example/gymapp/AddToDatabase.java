package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToDatabase extends AppCompatActivity {

    EditText  name, type, duration, goal, date;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_database);

        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        duration = findViewById(R.id.duration);
        goal = findViewById(R.id.goal);
        date = findViewById(R.id.date);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddToDatabase.this);
                myDB.addPlanner(name.getText().toString().trim(),
                        type.getText().toString().trim(),
                        Integer.valueOf(duration.getText().toString().trim()),
                        goal.getText().toString().trim(),
                        date.getText().toString().trim()


                );

            }
        });


    }
}
