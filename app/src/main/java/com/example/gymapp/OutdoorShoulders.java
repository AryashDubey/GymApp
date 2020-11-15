package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutdoorShoulders extends AppCompatActivity {
    TextView firstShouldersworkout, secondShouldersworkout, thirdShouldersworkout, fouthShouldersworkout;
    View backer;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_shoulders);

        firstShouldersworkout =(TextView) findViewById(R.id.shoulders1);
        secondShouldersworkout = (TextView) findViewById(R.id.shoulders2);
        thirdShouldersworkout = (TextView) findViewById(R.id.shoulders3);
        fouthShouldersworkout = (TextView)findViewById(R.id.shoulders4);


        backer = (View) findViewById(R.id.view2);
        firstShouldersworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //Opens warmup timer as a offer to warrm up and afterwards the warmup user can skip or skip within the process of warmup
                Intent a = new Intent(OutdoorShoulders.this,OutdoorPushUps.class);
                startActivity(a);
            }
        });

        secondShouldersworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens second workout activity Reverse hand on arm workout
                Intent a = new Intent(OutdoorShoulders.this,OutdoorStandUp.class);
                startActivity(a);
            }
        });
        thirdShouldersworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorShoulders.this,OutdoorStaggered.class);
                startActivity(a);
            }
        });
        fouthShouldersworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorShoulders.this,OutdoorPlankLats.class);
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