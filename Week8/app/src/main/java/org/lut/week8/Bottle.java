package org.lut.week8;

public class Bottle {

    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double prize;


    public Bottle(){
        this.name = "Pepsi Max";
        this.manufacturer = "Pepsi";
        this.total_energy = 0.3;
        this.size = 0.5;
        this.prize = 1.80;
    }

    public Bottle(String name, String manuf, double totE, double size, double price){
        this.name = name;
        this.manufacturer = manuf;
        this.total_energy = totE;
        this.size = size;
        this.prize = price;
    }

    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getSize() {
        return this.size;
    }
    public double getPrice() {
        return this.prize;
    }
    public void setSize(double new_size) {
        this.size = new_size;
    }
    public void setPrice(double price) {
        this.prize = price;
    }


    public String printBottle() {
        return "bottles";
    }
}
