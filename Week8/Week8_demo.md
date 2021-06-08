## Demonstration of Week 8 assignments   

Tools used: **Android Studio 4.2.1**   

[source java code here](https://github.com/saugkim/Olio2021s_LUT/blob/main/Week8/app/src/main/java/org/lut/week8) 

### Assignments  
8.1. Change the BottleDispenser so taht it uses the Singleton design pattern meaning that you can only create one object at a time.

```
public class BottleDispenser {
    // private constructor
    private BottleDispenser() {
        // implementation (adding bottles to the machine)
    }
    private static BottleDispenser instance;
    public static BottleDispenser getInstance(){
        if (instance == null) {
            instance = new BottleDispenser();
        }
        return instance;
    }
}
```

8.2-5. Demo clip for other tasks  

![me](https://github.com/saugkim/Olio2021s_LUT/blob/main/Week8/week8.gif)

8.2. Create a graphical user interface for the BottleDispenser.  
Use the functionality that has already been made, change the console prints to a graphical user interface. 

    3 button objects (add Money, buy Bottle, return Money)  
    print output message at the TextView object  


8.3. Modify the user interface in such a way that it is possible to change the amount of money you put to the BottleDispenser.  
It is recommended to use SeekBar-component that works as a slider to change the amount of money given. You will still need a button to that adds the money and resets SeekBar.

    1 SeekBar object and 1 TextView object on top of the add Money button 
    TextView to show the selected value from the seekbar  
    
    
8.4. Add a possibility to buy different sodas in different sizes.  
One possiblity is to use drop-down list for buying the bottles.   
This means the user chooses from the drop-down list the bottle they want to buy and its size.  Afterwards the BottleDispenser either sells the product or says that they are out.

    1 Spinner object (to select item, there are total 6 different type of product to buy) 
    on top of the Buy Botton


8.5. Add a functionality that makes it possible to print receipt of the last purchase for the user. The receipt should contain information that it is a receipt and what was purchased (name and price at least). The receipt is not printed to the user interface but instead, written to a file (that is defined in the program).
    
    1 Button object to print receipt to a file
    filename is timestamp.txt, user does not take care of this.

