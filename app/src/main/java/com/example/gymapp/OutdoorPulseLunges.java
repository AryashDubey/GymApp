package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class OutdoorPulseLunges extends AppCompatActivity {
    private TextView Basic;
    private TextView Complex;
    private TextView Extreme;
    private TextView time; //timer
    private TextView finish;
    private TextView count;
    private TextView count2;
    private TextView count3;

    private int Counter1 = 0;
    private int Counter2 = 0;
    private int Counter3 = 0;

    private CountDownTimer cw = null;
    private CountDownTimer cw2 = null;
    private CountDownTimer cw3 = null;
    private CountDownTimer cwer = null;
    private CountDownTimer cwe2 = null;
    private CountDownTimer cwe3 = null;

    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_pulse_lunges);
        Basic = (TextView) findViewById(R.id.Basic);
        Complex = (TextView) findViewById(R.id.Complex);
        Extreme = (TextView) findViewById(R.id.Extreme);
        time = (TextView) findViewById(R.id.time);
        finish =(TextView)findViewById(R.id.finishWorkout);
        count = (TextView)findViewById(R.id.count);
        count2 = (TextView)findViewById(R.id.count2);
        count3 = (TextView)findViewById(R.id.count3);


        Basic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cw = new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        time.setText("" + millisUntilFinished / 1000);
                        cancelTimer2(); //Cancel timer2
                        cancelTimer3();
                        resetCount2();
                        resetCount3();
                    }

                    public void onFinish() {
                        cw.start(); //looping timer
                        time.setText("Rest 10 Seconds" );
                        Counter1++; //Count amount of workout
                        count.setText(Integer.toString(Counter1));
                        Update1();  //Next timer 10  seconds rest
                    }
                }.start();
                running = true;
                count.setVisibility(View.VISIBLE);
                count2.setVisibility(View.INVISIBLE); //Hides other counters display
                count3.setVisibility(View.INVISIBLE); //Hides other counters
            }
        });

        Complex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cw2 =new CountDownTimer(60000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        time.setText("" + millisUntilFinished / 1000);
                        cancelTimer1();
                        cancelTimer3();


                    }

                    public void onFinish() {
                        time.setText("Rest 20 Seconds");
                        cw2.start(); //loop
                        Counter2++; //Count amount of workout
                        count2.setText(Integer.toString(Counter2));
                        Update2();

                    }
                }.start();

                count.setVisibility(View.INVISIBLE);   //Hides other counters display
                count2.setVisibility(View.VISIBLE);   //Makes counter Visible
                count3.setVisibility(View.INVISIBLE); //Hides other counters
            }

        });

        Extreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cw3 = new CountDownTimer(90000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        time.setText("" + millisUntilFinished / 1000);
                        cancelTimer1();
                        cancelTimer2();


                    }

                    public void onFinish() {
                        time.setText("Rest 30 Seconds");
                        cw3.start();
                        Counter3++; //Count amount of workout
                        count3.setText(Integer.toString(Counter3));
                        Update3();// 30 Seconds Display
                    }
                }.start();

                count.setVisibility(View.INVISIBLE);   //Hides other counters display
                count2.setVisibility(View.INVISIBLE); //Hides other counters
                count3.setVisibility(View.VISIBLE);  //Makes count visible
            }
        });

        //updateCount();
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        //Video of Plank Push Up
        final VideoView videoView = findViewById(R.id.videoViewArmPlank);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.plunge;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });


    }

    private void cancelTimer1() {
        if(cw!=null)
            cw.cancel();
    }

    private void cancelTimer2() {
        if(cw2!=null)
            cw2.cancel();
    }
    private void cancelTimer3() {
        if(cw3!=null)
            cw3.cancel();
    }




    public void Update1(){
        cwer = new CountDownTimer(11000, 100) { //10 Seconds Rest


            public void onTick(long millisUntilFinished) {
                time.setText("Rest for 10 seconds " + millisUntilFinished / 100);

                cancelTimer2();
                cancelTimer3();

            }

            public void onFinish() {
                cw.start(); //looping timer
                // hand.postDelayed((h,5000);
                time.setText("Rest 10- Seconds");

            }

        }.start();

    }
    public void Update2(){
        cwe2 = new CountDownTimer(16000, 100) { //15 Seconds Rest


            public void onTick(long millisUntilFinished) {
                time.setText("Rest for 15 seconds " + millisUntilFinished / 100);

                cancelTimer2();
                cancelTimer3();
            }

            public void onFinish() {
                cw2.start(); //looping timer
                // hand.postDelayed((h,5000);
                time.setText("Rest 10- Seconds");

            }

        }.start();

    }
    public void Update3(){
        cwe3 = new CountDownTimer(31000, 100) { //30 Seconds Rest
            public void onTick(long millisUntilFinished) {
                time.setText("Rest for 30 seconds " + millisUntilFinished / 100);
                cancelTimer2();
                cancelTimer3();
            }
            public void onFinish() {
                cw3.start(); //looping timer
                time.setText("Rest 30 Seconds");
            }
        }.start();
    }
    public void resetCount1(){
        Counter1 = 0;
        count.setText(Integer.toString(Counter1));

    }

    public void resetCount2(){
        Counter2 = 0;
        count2.setText(Integer.toString(Counter2));

    }
    public void resetCount3(){
        Counter3 = 0;
        count3.setText(Integer.toString(Counter3));

    }

}
