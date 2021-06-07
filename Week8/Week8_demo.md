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

8.2. Create a graphical user interface for the BottleDispenser.  
Use the functionality that has already been made, change the console prints to a graphical user interface. 

print output at the TextView object  
