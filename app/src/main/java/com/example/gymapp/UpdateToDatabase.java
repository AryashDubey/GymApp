package com.example.gymapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateToDatabase extends AppCompatActivity {

    EditText name2, type2, duration2, goal2, date2;
    Button update_button, delete_button;
    String id, name, type, duration, goal, date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_to_database);

        name2 = findViewById(R.id.name2);
        type2 = findViewById(R.id.type2);
        duration2 = findViewById(R.id.duration2);
        goal2 = findViewById(R.id.goal2);
        date2 = findViewById(R.id.date2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();   //setting actionbar


        if (ab != null) {   //getting titlename
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateToDatabase.this);
               // myDB.updateData(id, name, type, duration);

                name = name2.getText().toString().trim();
                type = type2.getText().toString().trim();
                duration = duration2.getText().toString().trim();
                goal = goal2.getText().toString().trim();
                date = date2.getText().toString().trim();
                myDB.updateData(id,name, type, duration, goal, date);

            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();

            }
        });



    }


        void getAndSetIntentData(){
            if (getIntent().hasExtra("id")&&getIntent().hasExtra("name")&&         //if there data transferred to new activity execute get
                    getIntent().hasExtra("type") && getIntent().hasExtra("duration")){
                //Getting Data from Intent
                 id = getIntent().getStringExtra("id");
                 name= getIntent().getStringExtra("name");
                 type = getIntent().getStringExtra("type");
                 duration = getIntent().getStringExtra("duration");
                 goal = getIntent().getStringExtra("goal");
                 date = getIntent().getStringExtra("date");




                //Setting Intent Data
                name2.setText(name);
                type2.setText(type);
                duration2.setText(duration);
                goal2.setText(goal);
                date2.setText(date);

            }else {

                Toast.makeText(this,"no information found" , Toast.LENGTH_SHORT).show();
            }


        }

        void confirmDialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(" Delete " + name + "?");
            builder.setMessage("Are you sure you want to delete " + name + " ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateToDatabase.this);
                    myDB.deleteRow(id);
                    finish();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();

        }


    }

