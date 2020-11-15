package com.example.gymapp;

import java.text.DecimalFormat;

public class BMI {




    public static String calculateBMI (double weight, double height, String unit) {
        double result;
            if(unit.equals("Imperial")) {
                result = (weight / (height * height)) * 703;
            }else{

                result = (weight/((height/100)*( height/100.0)));
            }

        return new DecimalFormat("##.##").format(result);
            /*
                Underweight: BMI < 18.5
                Normal: BMI 18 - 25
                Overweight: BMI 25 - 30
                Obese: BMI > = 30?

             */

    }






    public static String bmiStatus(double bmi){

        String status;

        if (bmi<18.5){
            status = "Underweight";
        }else if (bmi >= 18.5 && bmi <= 25) {
            status = "Normal";
        }else if(bmi >= 25 && bmi <= 30) {
            status = "Overweight";
        }else if(bmi >= 30) {
            status = "Obese";
        }   else{
            status = "Invalid";

        }
        return status;
    }






}
