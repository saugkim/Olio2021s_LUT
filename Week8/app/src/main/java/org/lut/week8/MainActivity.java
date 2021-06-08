package org.lut.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    BottleDispenser bd = BottleDispenser.getInstance();
    Button addMoneyBtn, buyBottleBtn, returnMoneyBtn;
    TextView textView;
    SeekBar seekBar;
    TextView barValue;
    Spinner spinner;
    int amount;
    int selectedIndex = -1;

    String recieptMessage = "";

    public static String DEFAULT_VALUE ="MONEY TO ADD: 0€";

    String[] products = {   "Cola Big(1L) 2.2€", "Cola Small(0.5L) 1.2€",
                            "Fanta Big(1L) 2.5€", "Fanta Small(0.5L) 1.5€",
                            "Sprite Big(1L) 2.2€", "Sprite Small(0.5L) 1.2€" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMoneyBtn = (Button) findViewById(R.id.addButton);
        buyBottleBtn = (Button) findViewById(R.id.buyButton);
        returnMoneyBtn = (Button) findViewById(R.id.returnButton);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Display message here");

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        barValue = (TextView) findViewById(R.id.varText);
        seekBar.setProgress(0);
        barValue.setText(DEFAULT_VALUE);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, products);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekValue = i;
                amount = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                barValue.setText("MONEY TO ADD: " + seekValue + "€");
            }
        });
    }

    public void setAmount(View v) {
        amount = seekBar.getProgress();
    }

    public void addMoney(View v){
        String ret = bd.addMoney(amount);
        textView.setText(ret);

        seekBar.setProgress(0);
        barValue.setText(DEFAULT_VALUE);
    }

    public void buyBottle(View v) {
        if (selectedIndex == -1) {
            textView.setText("select item from upper dropdown menu");
            return;
        }
        String ret = bd.buyBottle(selectedIndex);
        textView.setText(ret);
        recieptMessage = bd.print(selectedIndex);
        bd.removeBottle(selectedIndex);
    }

    public void printReceipt(View v) {

        textView.setText(recieptMessage);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        OutputStreamWriter osw = null;
        String s = recieptMessage;
        String filename = String.valueOf(timestamp.getTime() + ".txt");
        try {
            osw = new OutputStreamWriter(this.openFileOutput(filename, Context.MODE_PRIVATE));
            osw.write(s);
            osw.close();
            textView.setText(recieptMessage + "\nsaved in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnMoney(View v) {
        String ret = bd.returnMoney();
        textView.setText(ret);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        selectedIndex = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "Select from the dropdown menu", Toast.LENGTH_LONG).show();
    }
}
/*
8.3. Modify the user interface in such a way that it is possible to change the amount of money you put to the BottleDispenser.
It is recommended to use SeekBar-component that works as a slider to change the amount of money given.
You will still need a button to that adds the money and resets SeekBar.

8.4. Add a possibility to buy different sodas in different sizes.
One possiblity is to use drop-down list for buying the bottles.
This means the user chooses from the drop-down list the bottle they want to buy and its size.
Afterwards the BottleDispenser either sells the product or says that they are out
(you can use Spinner component for example).

8.5. Add a functionality that makes it possible to print receipt of the last purchase for the user.
The receipt should contain information that it is a receipt and what was purchased (name and price at least).
The receipt is not printed to the user interface but instead, written to a file (that is defined in the program).
*/
