package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.VideoView;

public class OutdoorWorkout extends AppCompatActivity { //up
    ImageButton imagebutton, imagebutton2, imagebutton3, imagebutton4, imagebutton5;
    TextView text1, text2, text3, text4;
    View backView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_workout);



        final VideoView videoView = findViewById(R.id.videoView2);
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




         text1=(TextView) findViewById(R.id.armtext);
         text3=(TextView) findViewById(R.id.chesttext);
         text4=(TextView) findViewById(R.id.shouldertext);
         text2=(TextView) findViewById(R.id.legstext);
         imagebutton5 =(ImageButton) findViewById(R.id.planner);
         backView =(View) findViewById(R.id.view11);

                //ARM WORKOUT
       text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OutdoorWorkout.this, Equipment_Arm_Workout.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
                    //CHEST WORKOUT
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OutdoorWorkout.this,OutdoorLegs.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
                    //LEG WORKOUT
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OutdoorWorkout.this,OutdoorChest.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
                    //SHOULDERS
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OutdoorWorkout.this,OutdoorShoulders.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
                    //Planner
        imagebutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(OutdoorWorkout.this, Planner.class);
                startActivity(a);
            }
        });


        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });




















    }
}
