package org.lut.week8;

import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private double money;
    private ArrayList<Bottle> bottleList = new ArrayList<Bottle>();

    private BottleDispenser() {
        bottles = 5;
        money = 0.0;

        Bottle bot1 = new Bottle();
        bottleList.add(bot1);

        Bottle bot2 = new Bottle("Pepsi Max", "Pepsi", 1, 1.5, 2.2);
        bottleList.add(bot2);

        Bottle bot3 = new Bottle("Coca-Cola Zero", "Coca", 0.5, 0.5, 2.0);
        bottleList.add(bot3);

        Bottle bot4 = new Bottle("Coca-Cola Zero", "Coca", 1.0, 1.5, 2.5);
        bottleList.add(bot4);

        Bottle bot5 = new Bottle("Fanta Zero", "Fanta", 0.5, 0.5, 1.95);
        bottleList.add(bot5);
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

            //String ret = String.format("%1$d. Name: %2$s\n", i+1, bottleList.get(i).getName());
            //String ret1 = String.format("\tSize: %1$.1f\tPrice: %2$.2f", bottleList.get(i).getSize(), bottleList.get(i).getPrice());
            //ret1 = ret1.replace(",", ".");
            //System.out.println(ret+ret1);
            String ret = String.format("%1$d. Name: %2$s\n", i+1, bottleList.get(i).getName());
            String koko = String.format("%1$.1f", bottleList.get(i).getSize());
            koko = koko.replace(",", ".");
            ret += "\tSize: " + koko + "\tPrice: ";
            String hinta = String.format("%1$.2f", bottleList.get(i).getPrice());
            //hinta = hinta.replace(",", ".");
            if (hinta.substring(hinta.length()-1).equals("0")) {
                hinta = hinta.substring(0, hinta.length()-1);
            }
            ret += hinta;
            System.out.println(ret);
        }
    }

    public void addMoney() {
        this.money += 1.0;
        System.out.println("Klink! Added more money!");
    }

    public void removeBottle(int index) {
        bottleList.remove(index);
    }

    public void buyBottle(String choice) {

        int idx = -1;
        idx = Integer.parseInt(choice)-1;
        System.out.println(idx);

        if (this.bottles >= 1 & this.money>=bottleList.get(idx).getPrice()) {
            this.bottles -= 1;
            this.money -= bottleList.get(idx).getPrice();
            System.out.println("KACHUNK! "+ bottleList.get(idx).getName() + " came out of the dispenser!");
            removeBottle(idx);
            return;
        }

        if (this.money < bottleList.get(idx).getPrice()) {
            System.out.println("Add money first!");
            return;
        }

    }

    public void returnMoney() {
        if (this.money == 0) {
            System.out.println("Klink klink!! All money gone!");
        } else {
            String tmp = String.format("%1$.2f", this.money);
            System.out.println("Klink klink. Money came out! You got "+tmp+"€ back");
        }

    }
}
