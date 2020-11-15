package com.example.gymapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ArmWorkout extends AppCompatActivity {
 ImageButton timer;
    TextView firstArmworkout, secondArmworkout, thirdArmworkout, fouthArmworkout ;
    View backer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workout);


        firstArmworkout = (TextView) findViewById(R.id.armWorkout1);
        secondArmworkout = (TextView) findViewById(R.id.armWorkout2);
        thirdArmworkout = (TextView) findViewById(R.id.armWorkout3);
        fouthArmworkout = (TextView)findViewById(R.id.armWorkout4);

        backer = (View) findViewById(R.id.view19);



        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent a = new Intent(ArmWorkout.this,GymWorkout.class);
                startActivity(a);
               // ArmWorkout.super.onBackPressed();


            }
        });


        firstArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //Opens warmup timer as a offer to warrm up and afterwards the warmup user can skip or skip within the process of warmup
                Intent a = new Intent(ArmWorkout.this,Timer.class);
                startActivity(a);
            }
        });

        secondArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens second workout activity Reverse hand on arm workout
                Intent a = new Intent(ArmWorkout.this,OutdoorReverseHand.class);
                startActivity(a);
            }
        });
        thirdArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(ArmWorkout.this,OutdoorStaggered.class);
                startActivity(a);
            }
        });
        fouthArmworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(ArmWorkout.this,OutdoorPlankUps.class);
                startActivity(a);
            }
        });
        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                finish();
            }
        });
    }

}
