package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodLoss extends AppCompatActivity {

    Button foodAdvice;

    String[] dietnamer = {"Water (7.00AM)", "Breakfast(8.00AM)","Water(8.30AM)", "Fruits(9.30AM)","Salad(12.00AM)","Fruits(1.00PM)","Eggs(3.00PM)","Water(3.30PM)","Rice(5.45)PM","Oats(9.00PM)"};
    String[] desc ={"First thing is consume a water at least 250ml Helps prep your body",
                    "Breakfast helps gain energy in the morning crucial for weight loss ",
                    "Contant consumption of water is healthy and helps weightloss quick",
                    "Fruits such as Orange are rich of vitamins, helps with weightloss",
                    "Salad is important as it contains less calories helps loss weight",
                    "Keep consuming different sorts of fruits rich of vitamins",
                    "Eggs contains minerals that are healthy for your body",
                    "More consupmtion of water to help your weight loss",
                    "Rice has lots of nutritions, healthy interms of weight loss",
                    "Oats has also got alot nutrition helps keep your body healthy"






    };
    int [] img ={R.drawable.waterbottle,R.drawable.breakfast,R.drawable.waterbottle,R.drawable.fruits,R.drawable.anna, R.drawable.fruits, R.drawable.eggy,R.drawable.waterbottle,R.drawable.rice,R.drawable.monica};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_loss);
        ListView listView = (ListView) findViewById(R.id.listviewer1);

        CustomAdapter customAdapter =  new CustomAdapter();

        listView.setAdapter(customAdapter);

        foodAdvice = findViewById(R.id.weightlossbtn);


        foodAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodLoss.this, WeightLossInformation.class);
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

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
            view = getLayoutInflater().inflate(R.layout.customlayou,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView0);
            TextView dietname = (TextView)view.findViewById(R.id.dietname);
            TextView des = (TextView)view.findViewById(R.id.des);
            imageView.setImageResource(img[i]);
            dietname.setText(dietnamer[i]);
            des.setText(desc[i]);

            return view;
        }


    }


}