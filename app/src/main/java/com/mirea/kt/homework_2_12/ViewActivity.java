package com.mirea.kt.homework_2_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataBaseSQLiteHelper dataBase;
    DBHelper dbHelper;
    List<Car> car = new ArrayList<>();

    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView=findViewById(R.id.rvContainer);

        dataBase = new DataBaseSQLiteHelper(this);
        dbHelper = new DBHelper(dataBase);

        car = dbHelper.getAll();
        updateRecyclerView(car);
    }

    private void updateRecyclerView(List<Car> car) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        carAdapter = new CarAdapter(ViewActivity.this,car,carClickListener);
        recyclerView.setAdapter(carAdapter);
    }
    private final CarClickListener carClickListener = new CarClickListener(){

        @Override
        public void onClick(Car car) {
            Toast.makeText(getApplicationContext(),"Клик :)",Toast.LENGTH_SHORT).show();
        }
    };
}