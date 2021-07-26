package org.lut.week9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    XmlHandling xmlHandling;
    Button button1;
    TextView textView;

    Spinner spinner, spinner2, spinner3, spinner3child;
    String[] theaters, startAfter, startBefore;

    ArrayList<String> theaterList;
    ArrayList<String> dateList;
    ArrayList<String> movieList;

    ArrayAdapter<String> adapter4;

   // ArrayList<String> startAfterTimeList;
   // ArrayList<String> startBeforeTimeList;

    ArrayList<String> listTodaySelectedArea;

    String selectedTheater = "";
    String selectedDate = "";
    int selectedTimeA = 0;
    int selectedTimeB = 0;
    String selectedMovie= "";
    Boolean isDateTimeSelected = false;
    Boolean isAreaSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        movieList = new ArrayList<>();
        theaterList = new ArrayList<>();
        dateList = new ArrayList<>();
        listTodaySelectedArea = new ArrayList<>();

        // getMovieList();
        // getDateList();
        // getTheaterList();
        theaters = getResources().getStringArray(R.array.theater_array);
        startAfter = Arrays.copyOfRange(getResources().getStringArray(R.array.time_array), 0,13);
        //startBefore = Arrays.copyOfRange(getResources().getStringArray(R.array.time_array), 1,12);

        xmlHandling = new XmlHandling();
        theaterList = xmlHandling.readTheatersFromXML();
        dateList = xmlHandling.readScheduleFromXML();

        textView =findViewById(R.id.textView);

        button1 = findViewById(R.id.button1);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner3child = findViewById(R.id.spinner3child);

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
        //ArrayAdapter<String> adapter4 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, startBefore);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner3child.setAdapter(adapter4);

        button1.setOnClickListener(view -> {
            //Fragment1 frag = new Fragment1();
            //FragmentManager manager = getSupportFragmentManager();
            //FragmentTransaction transaction = manager.beginTransaction();
            //transaction.replace(R.id.container, frag);
            //transaction.commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    Fragment1.newInstance(listTodaySelectedArea)).commit();
        });
    }

    public void getQueryResult(String location) {
        listTodaySelectedArea.clear();
        String url = xmlHandling.getXmlUrlString(location);
        listTodaySelectedArea.addAll(xmlHandling.getMoviesInSelectedAreaToday(url));
    }

    public void getQueryResult(String location, String dateInString) {
        listTodaySelectedArea.clear();
        String url = xmlHandling.getXmlUrlString(location, dateInString);
        listTodaySelectedArea.addAll(xmlHandling.getMoviesInSelectedAreaToday(url));
    }

    public void getQueryResult(String location, String dateInString, int timeStartAfter, int timeStartBefore) {
        listTodaySelectedArea.clear();
        String url = xmlHandling.getXmlUrlString(location, dateInString);
        listTodaySelectedArea.addAll(xmlHandling.getMoviesInSelectedAreaToday(url, timeStartAfter, timeStartBefore));
    }

    public String getSuperTemp() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < xmlHandling.getTheatersList().size(); i++) {
            System.out.println("hello");
        }
        String url = xmlHandling.getXmlUrlString("Espoo");

        for (int i=0; i<xmlHandling.getMoviesInSelectedAreaToday(url).size(); i++) {
            sb.append(xmlHandling.getMoviesInSelectedAreaToday(url).get(i)).append("\n");
        }
        return sb.toString();
    }

    public String getDate() {
        System.out.println("get Date method");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.ENGLISH);
        StringBuilder currentDate = new StringBuilder();
        for (int i=0; i<7 ; i++){
            currentDate.append(dateFormat.format(cal.getTime())).append("\n");
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
        return currentDate.toString();
    }

    public void getTheaterList() {
        theaterList = new ArrayList<>();
        theaterList.addAll(Arrays.asList(theaters));
    }


    public void getMovieList() {
        movieList = new ArrayList<>();
        movieList.add("Select Movie");
        movieList.add("Super Man");
        movieList.add("Iron Man");
        movieList.add("Spider Man");
    }

    public void getDateList() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.FRANCE);
        dateList = new ArrayList<>();
        dateList.add("Select Date");

        for (int i=0; i<7 ; i++){
            dateList.add(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        switch(adapterView.getId()){
            case R.id.spinner:
                if (pos != 0) {
                    isAreaSelected = true;
                }
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
                    adapter4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, startBefore);
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3child.setAdapter(adapter4);
                    spinner3child.setSelection(startBefore.length-1);
                    textView.setText("Select Time to start before");
                }
                break;
            case R.id.spinner3child:
                selectedTimeB = Integer.parseInt(adapterView.getSelectedItem().toString().substring(0,2));
                break;
            default:
                break;
        }
       // getQueryResult(selectedTheater, selectedDate);

        if (isAreaSelected && !isDateTimeSelected) {
            getQueryResult(selectedTheater, selectedDate);
            //getQueryResult(selectedTheater);
            //getSupportFragmentManager().beginTransaction().replace(R.id.container,
            //        Fragment1.newInstance(listTodaySelectedArea)).commit();
        } else if (isAreaSelected) {
            getQueryResult(selectedTheater, selectedDate, selectedTimeA, selectedTimeB);
        }
    }

    public String getSuperTemp2() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< listTodaySelectedArea.size() ; i++) {
            sb.append(listTodaySelectedArea.get(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("nothing");
    }
}