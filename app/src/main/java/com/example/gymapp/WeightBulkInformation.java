package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WeightBulkInformation extends AppCompatActivity {

    TextView weightbulkinfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_bulk_information);


        weightbulkinfor = findViewById(R.id.weightbulk);

        weightbulkinfor.setText(R.string.weightbulking);
    }
}
