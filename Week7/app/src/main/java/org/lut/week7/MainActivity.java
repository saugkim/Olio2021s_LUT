package org.lut.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Context context;

    Button button1, button2, button3, buttonSave, buttonLoad;
    TextView textView2, textView3, textView4, textView5;
    EditText editText3, editText4, editText5;

    public static String MESSAGE = "Hello World!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        editText3 = findViewById(R.id.inputField3);
        editText4 = findViewById(R.id.inputField4);
        editText5 = findViewById(R.id.inputField5);
        buttonSave = findViewById(R.id.button5save);
        buttonLoad = findViewById(R.id.button5load);

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String inputText = editText4.getText().toString();
                textView4.setText(inputText);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void showInConsoleTask1(View v) {
        System.out.println(MESSAGE);
    }
    public void showInWindowTask2(View v) {
        textView2.setText(MESSAGE);
    }
    public void showInWindowTask3(View v) {
        textView3.setText(editText3.getText().toString());
    }
    public void save(View v) {
        writeFile();
    }

    public void load(View v) {
        readFile();
    }

    public void writeFile() {

        AlertDialog ad = new AlertDialog.Builder(context).create();
        final EditText saveFileName = new EditText(context);

        ad.setView(saveFileName);
        ad.setMessage("Save File");

        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(saveFileName.getText().toString(), MODE_PRIVATE));
                    osw.write(editText5.getText().toString());
                    osw.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error occurred: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad.show();
        /*OutputStreamWriter osw = null;
        String s = editText5.getText().toString();
        try {
            osw = new OutputStreamWriter(context.openFileOutput("test.txt", Context.MODE_PRIVATE));
            osw.write(s);
            osw.close();
            System.out.println("saved");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void readFile() {
        AlertDialog ad = new AlertDialog.Builder(context).create();
        final EditText saveFileName = new EditText(context);
        ad.setView(saveFileName);
        ad.setMessage("Open File");

        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Open", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ret = "";
                String output = "";
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(context.openFileInput(saveFileName.getText().toString())));
                    System.out.println("Reading the file");
                    while ((output = br.readLine()) != null) {
                        ret += output;
                    }
                    textView5.setText(ret);

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error occurred: " + e, Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad.show();
      /*String ret = "";
        String output = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.openFileInput("test.txt")));
            System.out.println("Reading the file");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                ret += output;
            }
            textView5.setText(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
