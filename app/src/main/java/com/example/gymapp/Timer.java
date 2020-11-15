package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.TimerTask;

public class Timer extends AppCompatActivity {

    TextView textView;
    View skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        textView = (TextView) findViewById(R.id.textView8);
        skip = (View) findViewById(R.id.view9);

        if(!MainActivity.Timerrunning) {
            MainActivity.Timerrunning=true;
            new CountDownTimer(30000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView.setText("" + millisUntilFinished / 1000);
                }

                public void onFinish() {
                    textView.setText("Done");
                    MainActivity.Timerrunning=false;
                }


            }.start();
        }
                         {
        // OPENS NEW ACTIVITY AFTER WARM UP 30 SECONDS
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

               /* Intent intent = new Intent(Timer.this, WorkoutChoice.class);
                // If you just use this that is not a valid context. Use ActivityName.this
                startActivity(intent);
                 //The activity finished*/
            }
        }, 30000);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator() ) {
            vibrator.vibrate(500); // for 500 ms
        } }


        skip.setOnClickListener(new View.OnClickListener() {    //Skip and open new activity
            @Override
            public void onClick(View v) {

               finish();
                Intent intent = new Intent(Timer.this, OutdoorArmPlankToPushUp.class);
                startActivity(intent);
                finish();
            }


        });


    }





}
