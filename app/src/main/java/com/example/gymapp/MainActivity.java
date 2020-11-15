package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static Boolean Timerrunning = false;
    TextView buttontext;
    ImageView backgroudimage;
    Animation animationbackground, buttonanimation, blinker, blink;
    View view4, view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        blinker = AnimationUtils.loadAnimation(this,R.anim.blinker);
        view4 =(View) findViewById(R.id.view4) ;
        view4.startAnimation(blinker);


        blinker = AnimationUtils.loadAnimation(this,R.anim.blinker);
        view3 =(View) findViewById(R.id.view3) ;
        view3.startAnimation(blinker);



//------------------------------------------------------------------------------------------------------------------------------------------------


        animationbackground = AnimationUtils.loadAnimation(this,R.anim.animationbackground);
        buttontext = (TextView) findViewById(R.id.buttontext);
        buttontext.startAnimation(animationbackground);
        //animationbackground.setRepeatCount(Animation.INFINITE);


        buttonanimation = AnimationUtils.loadAnimation(this,R.anim.buttonanimation);
        backgroudimage = (ImageView) findViewById(R.id.buttonanimation);
        backgroudimage.startAnimation(buttonanimation);





        buttontext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent a = new Intent(MainActivity.this,WorkoutChoice.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(a);
        }
    });


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){}



}}


