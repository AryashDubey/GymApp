package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutdoorLegs extends AppCompatActivity {
    TextView firstLegworkout, secondLegworkout, thirdLegworkout, fouthLegworkout;
    Button backButton;
    View backer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_legs);

        firstLegworkout =(TextView) findViewById(R.id.leg1);
        secondLegworkout = (TextView) findViewById(R.id.leg2);
        thirdLegworkout = (TextView) findViewById(R.id.leg3);
        fouthLegworkout = (TextView)findViewById(R.id.leg4);


        backer  = (View) findViewById(R.id.view20);


        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent a = new Intent(OutdoorLegs.this,GymWorkout.class);
                startActivity(a);
                // ArmWorkout.super.onBackPressed();


            }
        });


        firstLegworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //Opens warmup timer as a offer to warrm up and afterwards the warmup user can skip or skip within the process of warmup
                Intent a = new Intent(OutdoorLegs.this,OutdoorSquats.class);
                startActivity(a);
            }
        });

        secondLegworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens second workout activity Reverse hand on arm workout
                Intent a = new Intent(OutdoorLegs.this,OutdoorPulseLunges.class);
                startActivity(a);
            }
        });
        thirdLegworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorLegs.this,JumpInAndOut.class);
                startActivity(a);
            }
        });
        fouthLegworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorLegs.this,OutdoorLegHold.class);
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
