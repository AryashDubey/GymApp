package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutdoorChest extends AppCompatActivity {
    TextView firstChestworkout, secondChestworkout, thirdChestworkout, fouthChestworkout, finish;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_chest);

        firstChestworkout =(TextView) findViewById(R.id.chest1);
        secondChestworkout = (TextView) findViewById(R.id.chest2);
        thirdChestworkout = (TextView) findViewById(R.id.chest3);
        fouthChestworkout = (TextView)findViewById(R.id.chest4);
        finish = (TextView) findViewById(R.id.finish);




        firstChestworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //Opens warmup timer as a offer to warrm up and afterwards the warmup user can skip or skip within the process of warmup
                Intent a = new Intent(OutdoorChest.this,OutdoorPushUps.class);
                startActivity(a);
            }
        });

        secondChestworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens second workout activity Reverse hand on arm workout
                Intent a = new Intent(OutdoorChest.this,OutdoorReverseHandPush.class);
                startActivity(a);
            }
        });
        thirdChestworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorChest.this,OutdoorStagger.class);
                startActivity(a);
            }
        });
        fouthChestworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                Intent a = new Intent(OutdoorChest.this,OutdoorPlankUps.class);
                startActivity(a);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Opens third workout activity Staggered on arm workout
                finish();
            }
        });
    }

}

