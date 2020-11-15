package com.example.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;




public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "Planner.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME = "my_planner";  //name of table
    private static final String COLUMN_ID = "_id";  // id
    private static final String COLUMN_NAME = "planner_name_of_workout";         //name of workout
    private static final String COLUMN_TYPE = "planner_type_of_workout";         // type of workout  (leg day, chest day, abs day)
    private static final String COLUMN_DURATION = "planner_results_of_workout";  //total completion of workout (50 push ups)
    private static final String COLUMN_GOAL = "planner_goal_of_workout";         // target workout to achieve
    private static final String COLUMN_DATE = "planner_date_of_workout";         // date of workout



    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_GOAL + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_DURATION + " INTERGER);";



        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    void addPlanner(String name, String type, int duration, String goal, String date) {
        SQLiteDatabase db = this.getWritableDatabase(); //write in table
        ContentValues cv = new ContentValues(); // stores all the data from application // so that pass through database table

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_TYPE, type);
        cv.put(COLUMN_DURATION, duration);
        cv.put(COLUMN_GOAL,goal);
        cv.put(COLUMN_DATE, date);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context, "Add Successful", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllDate() {       //read all data in the database table
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();


        //checking databse is not null
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String type, String duration, String goal, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_TYPE, type);
        cv.put(COLUMN_DURATION, duration);
        cv.put(COLUMN_GOAL, goal);
        cv.put(COLUMN_DATE, date);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();

        }

    }

    void deleteRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Success Delete", Toast.LENGTH_SHORT).show();
        }

    }


    void deleteAllDataOnDatabase(){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}

