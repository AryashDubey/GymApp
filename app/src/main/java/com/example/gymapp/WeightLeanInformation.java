package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WeightLeanInformation extends AppCompatActivity {

    TextView weightleaninfor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_lean_information);


        weightleaninfor = findViewById(R.id.weightlean);

        weightleaninfor.setText(R.string.weightleaning);
    }
}
