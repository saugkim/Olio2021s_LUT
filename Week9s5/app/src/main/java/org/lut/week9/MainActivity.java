package org.lut.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    XmlHandling xmlHandling;
    Button button1;
    TextView textView;

    Spinner spinner, spinner2, spinner3, spinner3child, spinner4;
    String[] startAfter, startBefore;

    ArrayList<String> theaterList;
    ArrayList<String> dateList;
    ArrayList<String> movieList;

    ArrayAdapter<String> adapter3child;

    ArrayList<String> listOfSelectedMovies;

    String selectedTheater = "";
    String selectedDate = "";
    int selectedTimeA = 0;
    int selectedTimeB = 0;
    String selectedMovie= "";
    Boolean isDateTimeSelected = false;
    Boolean isAreaSelected = false;
    Boolean isMovieSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        theaterList = new ArrayList<>();
        dateList = new ArrayList<>();
        movieList = new ArrayList<>();

        listOfSelectedMovies = new ArrayList<>();

        startAfter = Arrays.copyOfRange(getResources().getStringArray(R.array.time_array), 0,13);

        xmlHandling = new XmlHandling();

        theaterList = xmlHandling.readTheatersFromXML();
        dateList = xmlHandling.readScheduleFromXML();
        movieList = xmlHandling.getAllMovies();

        textView = findViewById(R.id.textView);

        button1 = findViewById(R.id.button1);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner3child = findViewById(R.id.spinner3child);
        spinner4 = findViewById(R.id.spinner4);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, theaterList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, dateList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, startAfter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3child.setOnItemSelectedListener(this);
        spinner3child.setPrompt("Select Time to start before");

        spinner4.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, movieList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        button1.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    Fragment1.newInstance(listOfSelectedMovies)).commit();
        });

    }

    public void getQueryResult(String location) {
        listOfSelectedMovies.clear();
        listOfSelectedMovies.addAll(xmlHandling.getMoviesInSelectedAreaToday(location));
    }

    public void getQueryResult(String date, int timeA, int timeB, String movie) {
        listOfSelectedMovies.clear();
        listOfSelectedMovies.addAll(xmlHandling.getMoviesInAllAreas(date, timeA, timeB, movie));
    }

    public void getQueryResult(String location, String date, int timeStartAfter, int timeStartBefore, String movie) {
        listOfSelectedMovies.clear();
        listOfSelectedMovies.addAll(xmlHandling.getMoviesInArea(location, date, timeStartAfter, timeStartBefore, movie));
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        switch(adapterView.getId()){
            case R.id.spinner:
                isAreaSelected = pos != 0;
                selectedTheater = adapterView.getSelectedItem().toString();
                break;
            case R.id.spinner2:
                selectedDate = adapterView.getSelectedItem().toString();
                break;
            case R.id.spinner3:
                if (pos != 0) {
                    isDateTimeSelected = true;
                    selectedTimeA = Integer.parseInt(adapterView.getSelectedItem().toString().substring(0,2));
                    String[] tmp = getResources().getStringArray(R.array.time_array);
                    startBefore = Arrays.copyOfRange(tmp, pos + 1, tmp.length);
                    adapter3child = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, startBefore);
                    adapter3child.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3child.setAdapter(adapter3child);
                    spinner3child.setSelection(startBefore.length-1);
                    textView.setText("Select Time to start before");
                }

                break;
            case R.id.spinner3child:
                selectedTimeB = Integer.parseInt(adapterView.getSelectedItem().toString().substring(0,2));
                break;
            case R.id.spinner4:
                selectedMovie = adapterView.getSelectedItem().toString();
                isMovieSelected = pos != 0;
            default:
                break;
        }

        if (isAreaSelected && !isDateTimeSelected) {
            getQueryResult(selectedTheater, selectedDate, 0, 0, selectedMovie);
        } else if (isAreaSelected) {
            getQueryResult(selectedTheater, selectedDate, selectedTimeA, selectedTimeB, selectedMovie);
        } else if (isMovieSelected && isDateTimeSelected){
            getQueryResult(selectedDate, selectedTimeA, selectedTimeB, selectedMovie);
        } else if(isMovieSelected){
            getQueryResult(selectedDate, 0,0, selectedMovie);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("nothing");
    }
}