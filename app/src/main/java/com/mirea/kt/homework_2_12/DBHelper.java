package com.mirea.kt.homework_2_12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class DBHelper {
    public static final String column_id = "_id";
    public static final String column_model = "model";
    public static final String column_number = "number";
    public static final String column_year = "year";
    public static final String NameTables = "car";

    private SQLiteOpenHelper sqLiteOpenHelpe;

    public DBHelper(SQLiteOpenHelper sqLiteOpenHelpe) {
        this.sqLiteOpenHelpe = sqLiteOpenHelpe;
    }

    public void addOne(Car car) {

        SQLiteDatabase db = this.sqLiteOpenHelpe.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_model, car.getModel());
        cv.put(column_number, car.getNumber());
        cv.put(column_year, car.getYear());
        db.insert(NameTables, null, cv);
        db.close();
    }

    public LinkedList<Car> getAll() {

        LinkedList<Car> list = new LinkedList<>();
        SQLiteDatabase db = this.sqLiteOpenHelpe.getWritableDatabase();

        Cursor cursor = db.query(NameTables,null,null,null,null,null,null);

        if(cursor.moveToFirst()) {
            do {
                int id_id = cursor.getColumnIndex(column_id);
                int id_model = cursor.getColumnIndex(column_model);
                int id_number = cursor.getColumnIndex(column_number);
                int id_year = cursor.getColumnIndex(column_year);

                Car car = new Car(cursor.getString(id_model),cursor.getString(id_number),cursor.getInt(id_year));
                list.add(car);

            } while (cursor.moveToNext());

        }
        db.close();
        return list;
    }



}
