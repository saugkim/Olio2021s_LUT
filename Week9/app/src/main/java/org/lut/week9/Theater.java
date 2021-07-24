package org.lut.week9;

public class Theater {
    String location;
    int id;

    public Theater() {

    }

    public Theater(String location, int id) {
        this.location = location;
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", location: " + getLocation();
    }
}
