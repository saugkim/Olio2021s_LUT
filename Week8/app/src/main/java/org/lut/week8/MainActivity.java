package org.lut.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //
    BottleDispenser bd = BottleDispenser.getInstance();
    Button addMoneyBtn, buyBottleBtn, returnMoneyBtn;
    TextView textView;
    SeekBar seekBar;
    TextView barValue;
    int amount;
    public static String DEFAULT_VALUE ="SELECT MONEY: 0€";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMoneyBtn = (Button) findViewById(R.id.addButton);
        buyBottleBtn = (Button) findViewById(R.id.buyButton);
        returnMoneyBtn = (Button) findViewById(R.id.returnButton);
        textView = (TextView) findViewById(R.id.textView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        barValue = (TextView) findViewById(R.id.varValue);
        seekBar.setProgress(0);
        barValue.setText(DEFAULT_VALUE);


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
                barValue.setText("SELECT MONEY: " + seekValue + "€");
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
        String ret = bd.buyBottle("1");
        textView.setText(ret);
    }

    public void returnMoney(View v) {
        String ret = bd.returnMoney();
        textView.setText(ret);
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

8.5. Add a functionality that makes it possible to print receipt of the last purchase for the user. The receipt should contain information that it is a receipt and what was purchased (name and price at least). The receipt is not printed to the user interface but instead, written to a file (that is defined in the program).
*/


/*
public static void printInfo() {
		String ret = "\n*** BOTTLE DISPENSER ***\r\n" +
				"1) Add money to the machine\r\n" +
				"2) Buy a bottle\r\n" +
				"3) Take money out\r\n" +
				"4) List bottles in the dispenser\r\n" +
				"0) End\r\n";
		System.out.print(ret);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BottleDispenser bd = new BottleDispenser();

		while(true) {
			printInfo();

		    System.out.print("Your Choice: ");
		    String choice = scanner.nextLine();

			if (choice.equals("0")){
				break;
			}

			switch(choice) {
				case "1":
					bd.addMoney();
					break;
				case "2":
					bd.listBottles();
					System.out.print("Your choice: ");
					choice = scanner.nextLine();
					bd.buyBottle(choice);
					break;
				case "3":
					bd.returnMoney();
					break;
				case "4":
					bd.listBottles();
					break;
				default:
					System.out.println("wrong input");
					break;
			}

		}
		scanner.close();
	}
 */