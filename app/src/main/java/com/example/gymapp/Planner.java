package com.example.gymapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Planner extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton addButton;

    ArrayList<String> planner_id, planner_name, planner_type, planner_duration, planner_goal, planner_date;
    MyDatabaseHelper myDB;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Planner.this, AddToDatabase.class);
                startActivity(intent);

            }
        });

        myDB = new MyDatabaseHelper(Planner.this);

        planner_id = new ArrayList<>();
        planner_name = new ArrayList<>();
        planner_type = new ArrayList<>();
        planner_duration = new ArrayList<>();
        planner_goal = new ArrayList<>();
        planner_date = new ArrayList<>();


        displayInfoArray();

        customAdapter = new CustomAdapter( Planner.this, this, planner_id, planner_name,planner_type, planner_duration, planner_goal, planner_date);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Planner.this));
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode,resultCode,data);

            if(requestCode == 1){
                recreate();
            } //refreshing the planner activity to begin again

        }


    void displayInfoArray() {   //display data of user input// ->database
        Cursor cursor = myDB.readAllDate();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else{
            while(cursor.moveToNext()){

                planner_id.add(cursor.getString(0));
                planner_name.add(cursor.getString(1));
                planner_type.add(cursor.getString(2));
                planner_duration.add(cursor.getString(3));
                planner_goal.add(cursor.getString(4));
                planner_date.add(cursor.getString(5));



            }



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);


    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.delete_all){
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            MyDatabaseHelper myDB = new MyDatabaseHelper(this);
            myDB.deleteAllDataOnDatabase();

            confirmDialog();

            //refreshese
            Intent intent = new Intent( this, Planner.class);
            startActivity(intent);
            finish();


        }

        return super.onOptionsItemSelected(item);

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Delete All");
        builder.setMessage("Are you sure you want to delete All Information?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Planner.this);

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
