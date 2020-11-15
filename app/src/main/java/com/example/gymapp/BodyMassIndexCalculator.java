package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BodyMassIndexCalculator extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{ // implementation of onItemSelectedListener Globally within the whole activity


    public String optionSelected;
     EditText weightInput;
     EditText heightInput;

     TextView bmiL;
     TextView bmsL;
     TextView result;
     TextView statusLabel;

     Spinner measure;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index_calculator);


         weightInput = findViewById(R.id.first);
         heightInput = findViewById(R.id.second);

        bmiL = findViewById(R.id.bmi);   //body mass index label
        bmsL  =   findViewById(R.id.bms); //body mass status label
        result      = findViewById(R.id.third);  // result display
        statusLabel      = findViewById(R.id.status); //  status display
        measure =  findViewById(R.id.spinner);




        measure.setOnItemSelectedListener(this); // picks up on itemSelected Adapter and  onNothingSelected Adapter


        result.setVisibility(View.INVISIBLE);
        statusLabel.setVisibility(View.INVISIBLE);
        bmiL.setVisibility(View.INVISIBLE);
        bmsL.setVisibility(View.INVISIBLE);

        TextView calculate    = findViewById(R.id.click);
      calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                String  userWeight  = weightInput.getText().toString();
                String  userHeight  =  heightInput.getText().toString();




                if(!userWeight.isEmpty() && !userHeight.isEmpty()){

                    String  bmiResult   =  BMI.calculateBMI (Double.parseDouble(userWeight),Double.parseDouble(userHeight),optionSelected);
                    String  status      = BMI.bmiStatus(Double.parseDouble(bmiResult));

                    result.setVisibility(View.VISIBLE);
                    statusLabel.setVisibility(View.VISIBLE);
                    bmiL.setVisibility(View.VISIBLE);
                    bmsL.setVisibility(View.VISIBLE);
                    result.setText(bmiResult);
                    statusLabel.setText(status);
                }
               else{
                   result.setVisibility(View.VISIBLE);
                   result.setText(R.string.errorText);
               }
           }
       });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        optionSelected =  parent.getItemAtPosition(position).toString();


        if (optionSelected.equals("Imperial")){
            weightInput.setHint("Weight (lb)");
            heightInput.setHint("Height (in)");
        }else{
            weightInput.setHint("Weight (kg)");
            heightInput.setHint("Height (cm)");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


