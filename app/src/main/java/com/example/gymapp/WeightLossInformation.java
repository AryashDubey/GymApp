package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WeightLossInformation extends AppCompatActivity {

       TextView weightlossinfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss_information);
        weightlossinfor = findViewById(R.id.weightloss);

        weightlossinfor.setText(R.string.weightlosing);

    }
}
