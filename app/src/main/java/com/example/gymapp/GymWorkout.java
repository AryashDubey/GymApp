package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.nio.file.Path;

public class GymWorkout extends AppCompatActivity {//down
        VideoView VideoView;
    //NO EQUIPMENT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_workout);

        View back;
        ImageButton but1, but2, but3, but4, but5;
        TextView arm, legs, shoulders, chest;
        //Button button;


        arm =  (TextView) findViewById(R.id.armgym) ;
        legs = (TextView) findViewById(R.id.legsgym);
        shoulders = (TextView) findViewById(R.id.shouldersgym);
        chest = (TextView) findViewById(R.id.chestgym);
        but5 = (ImageButton) findViewById(R.id.planner);

        back = (View) findViewById(R.id.viewGymWorkout);


            final VideoView videoView = findViewById(R.id.videoView);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.wesley;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            videoView.start();


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

                videoView.start();

                }
            });











            //ARM WORKOUT ACTIVITY
        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GymWorkout.this,ArmWorkout.class);
                startActivity(a);
            }
        });

       legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GymWorkout.this,OutdoorLegs.class);
                startActivity(a);



            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GymWorkout.this,OutdoorChest.class);
                startActivity(a);
            }
        });



        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GymWorkout.this,OutdoorShoulders.class);
                startActivity(a);
            }
        });


        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GymWorkout.this, Planner.class);
                startActivity(a);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    }

