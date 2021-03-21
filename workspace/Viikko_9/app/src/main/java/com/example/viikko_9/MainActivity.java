package com.example.viikko_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Spinner theaterSpinner;
    int theaterSelection = 0;
    RecyclerView moviesView;
    TextView dateView;
    TextView startTimeView;
    TextView endTimeView;
    TextView searchView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        theaterSpinner = findViewById(R.id.theater);
        moviesView = findViewById(R.id.movies);
        moviesView.setLayoutManager(new LinearLayoutManager(this));
        String url = "https://www.finnkino.fi/xml/TheatreAreas/";

        dateView = findViewById(R.id.Date);
        startTimeView = findViewById(R.id.StartTime);
        endTimeView = findViewById(R.id.EndTime);
        searchView = findViewById(R.id.Search);
        button = findViewById(R.id.button);

        Theaters theaters = new Theaters(url);

        ArrayAdapter ada = new ArrayAdapter(this, android.R.layout.simple_spinner_item, theaters.getTheaterNames());
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theaterSpinner.setAdapter(ada);

        theaterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            theaterSelection = position;
            updateRecyclerView(theaters, theaterSelection);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateView.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (theaterSelection != 0 && searchView.getText().length() == 0){
                    updateRecyclerView(theaters, theaterSelection);
                }
            }
        });

        startTimeView.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (theaterSelection != 0 && searchView.getText().length() == 0){
                    updateRecyclerView(theaters, theaterSelection);
                }
            }
        });

        endTimeView.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (theaterSelection != 0 && searchView.getText().length() == 0){
                    updateRecyclerView(theaters, theaterSelection);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theaterSelection = theaterSpinner.getSelectedItemPosition();
                search(theaterSelection, theaters);
            }
        });
    }
    public void updateRecyclerView(Theaters theaters, int theaterSelection){
        String day = dateView.getText().toString();
        String startTime = startTimeView.getText().toString();
        String endTime = endTimeView.getText().toString();

        if (day.length() == 0){
            day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        else {
            try {
                day = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd.M.yyyy")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }catch (DateTimeParseException e){
                return;
            }
        }
        if (startTime.length() == 0){
            startTime = "00:00";
        }
        else if (startTime.length() == 4){
            startTime = "0" + startTime;
        }
        if (endTime.length() == 0){
            endTime = "23:59";
        }
        else if (endTime.length() == 4){
            endTime = "0" + endTime;
        }
        if (theaterSelection != 0){
            ArrayList<String> array = theaters.getMovies(theaterSelection, day, startTime, endTime);
            if (array != null){
                RecyclerAdapter ReAda = new RecyclerAdapter(array);
                moviesView.setAdapter(ReAda);
            }

        }
    }

    public void search(int selection, Theaters theaters){
        String day = dateView.getText().toString();
        String startTime = startTimeView.getText().toString();
        String endTime = endTimeView.getText().toString();
        String s = searchView.getText().toString();

        if (day.length() == 0){
            day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        else {
            try {
                day = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd.M.yyyy")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }catch (DateTimeParseException e){
                return;
            }
        }
        if (startTime.length() == 0){
            startTime = "00:00";
        }
        else if (startTime.length() == 4){
            startTime = "0" + startTime;
        }
        if (endTime.length() == 0){
            endTime = "23:59";
        }
        else if (endTime.length() == 4){
            endTime = "0" + endTime;
        }
        ArrayList<String> array = theaters.search(selection, s, day, startTime, endTime);
        if (array != null) {
            RecyclerAdapter ReAda = new RecyclerAdapter(array);
            moviesView.setAdapter(ReAda);
        }

    }
}