package com.example.myapp;
import android.os.Build;
//import android.view.View;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import com.google.android.material.textfield.TextInputLayout;

//import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //_____________________
//        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);
        AutoCompleteTextView dropDown = findViewById(R.id.autoCompleteTextView);

        ArrayList<String> mealDropDownList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.Meals)));
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,mealDropDownList);
        dropDown.setAdapter(dropDownAdapter);

        //textInputLayout.getEditText();
        //_____________________
        Button submit = findViewById(R.id.submit);
        ListView mealList = findViewById(R.id.mealList);
//        EditText editMeal = findViewById(R.id.editMeal);
        ArrayList<String> foodList = new ArrayList<>();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,foodList);



        submit.setOnClickListener(view -> {
            mealList.setAdapter(listAdapter);
            //listAdapter.add(editMeal.getText().toString() + " " +  printDate());
            listAdapter.add(dropDown.getText().toString() + " " +  printDate());

//            editMeal.setText("");
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String printDate() {

        DateTimeFormatter date = DateTimeFormatter.ofPattern("\t\t\t\th:mm a \t\t\t\t\t\t\t\t\t\t\tMM/dd/yyyy ");
        LocalDateTime now = LocalDateTime.now();
//        String log = date.format(now);
        return date.format(now);
    }




}