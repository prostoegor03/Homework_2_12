package com.mirea.kt.homework_2_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etCarModel,etCarNumber,etCarYear;
    Button addButton,viewButton;
    List<Car> car =new ArrayList<>();

    DataBaseSQLiteHelper dataBase;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCarModel = findViewById(R.id.etCarModel);
        etCarNumber = findViewById(R.id.etCarNumber);
        etCarYear = findViewById(R.id.etCarYear);

        addButton = findViewById(R.id.addButton);
        viewButton = findViewById(R.id.viewButton);

        dataBase = new DataBaseSQLiteHelper(this);
        dbHelper = new DBHelper(dataBase);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model = etCarModel.getText().toString();
                String number = etCarNumber.getText().toString();
                int year = Integer.parseInt(etCarYear.getText().toString());

                if (!model.isEmpty() && !number.isEmpty() && year != 0){
                    Car car = new Car(model,number,year);
                    dbHelper.addOne(car);

                }else {
                    Toast.makeText(getApplicationContext(),"Пожалуйста заполните поля",Toast.LENGTH_SHORT).show();
                }
                etCarModel.getText().clear();
                etCarNumber.getText().clear();
                etCarYear.getText().clear();
            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

    }
}