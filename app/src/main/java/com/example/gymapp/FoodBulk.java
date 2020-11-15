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

public class FoodBulk extends AppCompatActivity {

    Button foodBulkAdvice;


    String[] dietnamer = {"Bulk Lean (7.00AM)","Eggs (8.30am)","Breakfast (9.00AM)","Fruits (10.00AM)","Lunch (12.00PM)","Salad(1.00PM)","Dinner(7.00PM)", "More Protein(9.00PM)"};
    String[] desc ={"Bulk Lean full of Vitamin A ",
            "Eggs full of healthy Vitamins",
            "Breakfast is important to start up your day",
            "Fruits such as Orange are rich of vitamins",
            "Lunch is full of protein like fish and chicken",
            "Salad helps improve muscle performance",
            "Dinner; Seafood or Vegetarian",
            "Don't be afraid of body fat, its important for bulking",
            "Please ensure your total calories consumpution is 2884 kcal  "

    };
    int [] img ={R.drawable.eggy,R.drawable.fruits,R.drawable.breakfast, R.drawable.fruits,R.drawable.lunch,R.drawable.anna,R.drawable.dinner,R.drawable.mark};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_bulk);

        ListView listView = (ListView) findViewById(R.id.listviewer2);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);


        foodBulkAdvice = findViewById(R.id.foodbulkbtn);


        foodBulkAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodBulk.this, WeightBulkInformation.class);
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
            view = getLayoutInflater().inflate(R.layout.customlayout2,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView2);
            TextView dietname = (TextView)view.findViewById(R.id.dietname2);
            TextView des = (TextView)view.findViewById(R.id.des2);

            imageView.setImageResource(img[i]);
            dietname.setText(dietnamer[i]);
            des.setText(desc[i]);



            return view;
        }
    }
}
