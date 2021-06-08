package org.lut.week8;

import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private double money;
    private ArrayList<Bottle> bottleList = new ArrayList<Bottle>();

    String[] products = {  "Cola Big(1L) 2.2€", "Cola Small(0.5L) 1.2€",
            "Fanta Big(1L) 2.5€", "Fanta Small(0.5L) 1.5€",
            "Sprite Big(1L) 2.2€", "Sprite Small(0.5L) 1.2€" };

    private BottleDispenser() {
        bottles = 30;
        money = 0.0;

        for (int i=0; i < 5 ; i++) {

            Bottle bot1 = new Bottle(0, "Cola Max", "Pepsi", 1.0, 1.0, 2.2);
            bottleList.add(bot1);

            Bottle bot2 = new Bottle(1, "Cola", "Pepsi", 0.5, 0.5, 1.2);
            bottleList.add(bot2);

            Bottle bot3 = new Bottle(2, "Fanta Max", "Fanta", 1.0, 1.0, 2.5);
            bottleList.add(bot3);

            Bottle bot4 = new Bottle(3, "Fanta", "Fanta", 0.5, 0.5, 1.5);
            bottleList.add(bot4);

            Bottle bot5 = new Bottle(4, "Sprite Max", "Pepsi", 1.0, 1.0, 2.2);
            bottleList.add(bot5);

            Bottle bot6 = new Bottle(5, "Sprite", "Pepsi", 0.5, 0.5, 1.2);
            bottleList.add(bot6);
        }
    }

    private static BottleDispenser instance;
    public static BottleDispenser getInstance(){
        if (instance == null) {
            instance = new BottleDispenser();
        }
        return instance;
    }

    public void listBottles() {
        for (int i=0; i<bottles;i++) {
            String ret = String.format("%1$d. Name: %2$s\n", i+1, bottleList.get(i).getName());
            String koko = String.format("%1$.1f", bottleList.get(i).getSize());
            ret += "\tSize: " + koko + "\tPrice: ";
            String hinta = String.format("%1$.2f", bottleList.get(i).getPrice());
            if (hinta.substring(hinta.length()-1).equals("0")) {
                hinta = hinta.substring(0, hinta.length()-1);
            }
            ret += hinta;
            System.out.println(ret);
        }
    }

    public String addMoney(double amount) {
        this.money += amount;
        return "Klink! Added " + amount + "€, Total: " + this.money +"€!";
    }

    public void removeBottle(int index) {
        for (int i=0; i<this.bottles; i++) {
            if (bottleList.get(i).getProductID() == index) {
                bottleList.remove(i);
                break;
            }
        }
    }

    public String buyBottle(int index) {
        String ret="";

        int idx = -1;
        for (int i=0; i<this.bottles; i++) {
            if (bottleList.get(i).getProductID() == index) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return products[index] + "IS SOLD OUT";
        }

        if (idx != -1 & this.money>=bottleList.get(idx).getPrice()) {
            this.bottles -= 1;
            this.money -= bottleList.get(idx).getPrice();
            ret = "KACHUNK! " + bottleList.get(idx).getName() + " came out of the dispenser!";
            //removeBottle(idx);
            return ret;
        }
        if (this.money < bottleList.get(idx).getPrice()) {
            return "Add money first!";
        }

        return ret;
    }

    public String returnMoney() {
        String ret = "";
        if (this.money == 0) {
            ret = "Klink klink!! All money gone!";
        } else {
            String tmp = String.format("%1$.2f", this.money);
            //System.out.println("Klink klink. Money came out! You got "+tmp+"€ back");
            ret = "Klink klink. Money came out! You got " + tmp + "€ back";
        }
        return ret;
    }

    public String print(int index){
        String ret = "";
        for (int i=0; i<this.bottles; i++) {
            if (bottleList.get(i).getProductID() == index) {
                ret = bottleList.get(i).printBottle();
                break;
            }
        }
        return ret;
    }
}
