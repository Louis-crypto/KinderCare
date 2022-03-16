package com.moringaschool.kindercare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String VACCINE_TABLE = "VACCINE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_VACCINE_NAME = "VACCINE_NAME";
    public static final String COLUMN_VACCINE_DESCRIPTION = "VACCINE_DESCRIPTION";
    public static final String COLUMN_VACCINE_DOSES = "VACCINE_DOSES";
    public static final String COLUMN_VACCINE_AGELIMIT = "VACCINE_AGELIMIT";
    public static final String COLUMN_VACCINE_AVAILABLE = "VACCINE_AVAILABLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "VaccineDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + VACCINE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_VACCINE_NAME + " TEXT, " + COLUMN_VACCINE_DESCRIPTION + " TEXT, " + COLUMN_VACCINE_DOSES + " INT, " + COLUMN_VACCINE_AGELIMIT + " TEXT, " + COLUMN_VACCINE_AVAILABLE + " BOOL)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(VaccineModel vaccineModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_VACCINE_NAME, vaccineModel.getVaccineName());
        contentValues.put(COLUMN_VACCINE_DESCRIPTION, vaccineModel.getDescription());
        contentValues.put(COLUMN_VACCINE_DOSES, vaccineModel.getDoses());
        contentValues.put(COLUMN_VACCINE_AGELIMIT, vaccineModel.getAgeLimit());
        contentValues.put(COLUMN_VACCINE_AVAILABLE, vaccineModel.isAvailable());

        long insert = db.insert(VACCINE_TABLE, null, contentValues);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public List<VaccineModel> getAllVaccines(){
        List<VaccineModel> listOfVaccines = new ArrayList<>();
        String queryDB = "SELECT * FROM " + VACCINE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryDB,null);
        if(cursor.moveToFirst()){
            do{
                int vaccineID = cursor.getInt(0);
                String vaccineName = cursor.getString(1);
                String vaccineDescription = cursor.getString(2);
                int vaccineDoses = cursor.getInt(3);
                String vaccineAgeLimit = cursor.getString(4);
                boolean availableVaccine = cursor.getInt(5) ==1 ? true: false;

                VaccineModel newVaccine = new VaccineModel(vaccineID, vaccineName, vaccineDescription, vaccineDoses, vaccineAgeLimit, availableVaccine);

                listOfVaccines.add(newVaccine);

            }while (cursor.moveToNext());
        }
        else{

        }

        cursor.close();
        db.close();
        return listOfVaccines;
    }

}
