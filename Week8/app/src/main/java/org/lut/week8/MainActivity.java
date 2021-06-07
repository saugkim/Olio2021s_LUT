package org.lut.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //
    BottleDispenser bd = BottleDispenser.getInstance();
    Button addMoneyBtn, buyBottleBtn, returnMoneyBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMoneyBtn = (Button) findViewById(R.id.addButton);
        buyBottleBtn = (Button) findViewById(R.id.buyButton);
        returnMoneyBtn = (Button) findViewById(R.id.returnButton);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void addMoney(View v){
        String ret = bd.addMoney();
        textView.setText(ret);
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