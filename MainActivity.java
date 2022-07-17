package com.example.myapp;
import android.os.Build;
import android.view.View;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = findViewById(R.id.submit);
        ListView mealList = findViewById(R.id.mealList);
        EditText editMeal = findViewById(R.id.editMeal);
        ArrayList<String> foodList = new ArrayList<String>();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,foodList);


        submit.setOnClickListener(view -> {
            mealList.setAdapter(listAdapter);
            listAdapter.add(editMeal.getText().toString() + " " +  printDate());
            //editMeal.setText("setting meal");
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String printDate() {

        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String log = date.format(now);
        return log;
    }




}