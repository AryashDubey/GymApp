package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutChoice extends AppCompatActivity {

    View backView;
    ImageButton imageButton, imageButton2, food, Calculator;
    Animation workoutchoiceanimationbackground, workoutchoicebuttonanimation, workoutchoiceblinker,animationbackground, animationback, but2, but3, but4, fooder, calculator ;
    TextView textViewTwo,textViewThree, textViewTen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_choice);





        workoutchoiceblinker = AnimationUtils.loadAnimation(this,R.anim.workoutchoiceblinker);
        textViewThree = (TextView) findViewById(R.id.textView3);
        textViewThree.startAnimation(workoutchoiceblinker);



        workoutchoiceanimationbackground = AnimationUtils.loadAnimation(this,R.anim.workoutchoiceblinker);
        textViewTwo = (TextView) findViewById(R.id.textView2);
        textViewTwo.startAnimation(workoutchoiceanimationbackground);


        fooder = AnimationUtils.loadAnimation(this,R.anim.workoutchoiceblinker);
        textViewThree = (TextView) findViewById(R.id.textView10);
        textViewThree.startAnimation(fooder);

        calculator = AnimationUtils.loadAnimation(this,R.anim.workoutchoiceblinker);
        textViewThree = (TextView) findViewById(R.id.textView12);
        textViewThree.startAnimation(calculator);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        workoutchoicebuttonanimation = AnimationUtils.loadAnimation(this,R.anim.workoutchoicebuttonanimation);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.startAnimation(workoutchoicebuttonanimation);


        but2 = AnimationUtils.loadAnimation(this,R.anim.workoutchoicebuttonanimation);
        imageButton = (ImageButton) findViewById(R.id.imageButton2);
        imageButton.startAnimation(but2);

        but3 = AnimationUtils.loadAnimation(this,R.anim.workoutchoicebuttonanimation);
        imageButton = (ImageButton) findViewById(R.id.food);
        imageButton.startAnimation(but3);

        but4 = AnimationUtils.loadAnimation(this,R.anim.workoutchoicebuttonanimation);
        imageButton = (ImageButton) findViewById(R.id.calculator);
        imageButton.startAnimation(but4);


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                            //back text
        animationback = AnimationUtils.loadAnimation(this,R.anim.workoutchoiceblinker);
        textViewTen = (TextView) findViewById(R.id.textView5);
        textViewTen.startAnimation(animationback);

       // imageButton2.startAnimation(workoutchoicebuttonanimation);


//------------------------------------------------------------------------------------------------------------------------------------------------









        imageButton =(ImageButton) findViewById(R.id.imageButton);
        imageButton2 =(ImageButton) findViewById(R.id.imageButton2);
        backView = (View) findViewById(R.id.view11);
        food = (ImageButton) findViewById(R.id.food);
        Calculator=(ImageButton)findViewById(R.id.calculator);

        textViewTwo = (TextView) findViewById(R.id.textView2);
        textViewThree = (TextView) findViewById(R.id.textView3);
        //button3= (Button) findViewById(R.id.button3);
        //button4 =(Button) findViewById(R.id.button4);





        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //This opens the outdoor workout of the applicaiton
                Intent a = new Intent(WorkoutChoice.this,OutdoorWorkout.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //This one the Gym workout page of the applicaiton
                Intent a = new Intent(WorkoutChoice.this,GymWorkout.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });





        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           // This opens the Food Plan section of the workout applicaiton
                Intent a = new Intent(WorkoutChoice.this,Food.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        Calculator.setOnClickListener(new View.OnClickListener() {          // This opens the body mass index calcuation of the applicaiton
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutChoice.this,BodyMassIndexCalculator.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);

            }
        });

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }); //allows the user to go back to the first page of the application


    }





}
