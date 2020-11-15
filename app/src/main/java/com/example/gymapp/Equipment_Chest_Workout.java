package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Equipment_Chest_Workout extends AppCompatActivity {

    ImageButton timer;
    TextView firstArmworkout, secondArmworkout, thirdArmworkout, fouthArmworkout ;
    View backer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment__chest__workout);




        firstArmworkout = (TextView) findViewById(R.id.armWorkout1);
        secondArmworkout = (TextView) findViewById(R.id.armWorkout2);
        thirdArmworkout = (TextView) findViewById(R.id.armWorkout3);
        fouthArmworkout = (TextView) findViewById(R.id.armWorkout4);

        backer = (View) findViewById(R.id.view19);


        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent a = new Intent(Equipment_Chest_Workout.this, GymWorkout.class);
                startActivity(a);
                // ArmWorkout.super.onBackPressed();


            }
        });


        firstArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //Opens warmup timer as a offer to warrm up and afterwards the warmup user can skip or skip within the process of warmup
                Intent a = new Intent(Equipment_Chest_Workout.this, EquipmentBicepCurls.class);
                startActivity(a);
            }
        });

        secondArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens second workout activity Reverse hand on arm workout
                Intent a = new Intent(Equipment_Chest_Workout.this, EquipmentRussianTwist.class);
                startActivity(a);
            }
        });
        thirdArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(Equipment_Chest_Workout.this, EquipmentArmKickBack.class);
                startActivity(a);
            }
        });
        fouthArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(Equipment_Chest_Workout.this, EquipmentShoulderPushUp.class);
                startActivity(a);
            }
        });
        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                finish();
            }
        });
    }}











