package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodLean extends AppCompatActivity {

    Button foodLeanAdvice;

    String[] dietnamer = {"Water (7.00AM)","Oats (7.30AM)","Fruits(8.00AM)","Water(8.30AM)","Lunch(12.00PM)","Water(1.00PM)","Dinner(7.00PM)"};
    String[] desc = {"Start with water to get your body prep",
             "Oats is very healthy and has right nutrition for the morning",
             "Consume a mass amount of fruits to keep your nutrition up",
             "Continuing consuming water to keep your body healthy",
             "Eat protein foods and ensure that you are well fed ",
             "Continuing consuming water to keep your body healthy",
             "Consuming more protein is very helpful to get lean"

    };
    int [] img = {R.drawable.waterbottle, R.drawable.monica,R.drawable.fruits,R.drawable.waterbottle,R.drawable.lunch,R.drawable.waterbottle, R.drawable.dinner};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_lean);

        ListView listView = (ListView) findViewById(R.id.listviewer);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);


        foodLeanAdvice = findViewById(R.id.foodleanbtn);


        foodLeanAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodLean.this, WeightLeanInformation.class);
                startActivity(intent);
            }
        });


    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView dietname = (TextView)view.findViewById(R.id.dietname);
            TextView des = (TextView)view.findViewById(R.id.des);

            imageView.setImageResource(img[i]);
            dietname.setText(dietnamer[i]);
            des.setText(desc[i]);



            return view;
        }
    }
}
