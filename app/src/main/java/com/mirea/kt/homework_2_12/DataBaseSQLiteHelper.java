package com.mirea.kt.homework_2_12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQLiteHelper extends SQLiteOpenHelper {

    public static final String column_id = "_id";
    public static final String column_model = "model";
    public static final String column_number = "number";
    public static final String column_year = "year";
    public static final String car = "car";

    public DataBaseSQLiteHelper(@Nullable Context context) {
        super(context, "main.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + car + " (" + column_id
                + " integer primary key,"
                + column_model + " text,"
                + column_number + " text,"
                + column_year + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
