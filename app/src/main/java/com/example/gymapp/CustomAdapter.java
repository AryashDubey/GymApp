package com.example.gymapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList planner_id, planner_name, planner_type, planner_duration, planner_goal, planner_date;


    CustomAdapter(Activity activity, Context context, ArrayList planner_id, ArrayList planner_name, ArrayList planner_type, ArrayList planner_duration,ArrayList planner_goal, ArrayList planner_date){


        this.activity = activity;
        this.context = context;
        this.planner_id = planner_id;
        this.planner_name = planner_name;
        this.planner_type = planner_type;
        this.planner_duration = planner_duration;
        this.planner_goal = planner_goal;
        this.planner_date = planner_date;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapterrow, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {    //Getting Data string from arrays

        holder. Planner_id_text.setText(String.valueOf(planner_id.get(position)));
        holder. Planner_name_text.setText(String.valueOf(planner_name.get(position)));
        holder. Planner_type_text.setText(String.valueOf(planner_type.get(position)));
        holder. Planner_duration_text.setText(String.valueOf(planner_duration.get(position)));
        holder. Planner_goal_text.setText(String.valueOf(planner_goal.get(position)));
        holder. Planner_date_text.setText(String.valueOf(planner_date.get(position)));


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateToDatabase.class);

                intent.putExtra("id",String.valueOf(planner_id.get(position)));
                intent.putExtra("name",String.valueOf(planner_name.get(position)));
                intent.putExtra("type",String.valueOf(planner_type.get(position)));
                intent.putExtra("duration",String.valueOf(planner_duration.get(position)));
                intent.putExtra("goal",String.valueOf(planner_goal.get(position)));
                intent.putExtra("date",String.valueOf(planner_date.get(position)));


                activity.startActivityForResult(intent, 1); // makes  update visible
            }
        });
    }

    @Override
    public int getItemCount() {
        return planner_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView Planner_id_text, Planner_name_text, Planner_type_text, Planner_duration_text, Planner_goal_text, Planner_date_text;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Planner_id_text = itemView.findViewById(R.id.Planner_id_text);
            Planner_name_text = itemView.findViewById(R.id.Planner_name_text);
            Planner_type_text = itemView.findViewById(R.id.Planner_type_text);
            Planner_duration_text = itemView.findViewById(R.id.Planner_duration_text);
            Planner_goal_text = itemView.findViewById(R.id.Planner_goal_text);
            Planner_date_text = itemView.findViewById(R.id.Planner_date_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }






}
