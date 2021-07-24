package org.lut.week9;

import java.util.ArrayList;

public class TheaterController {

    ArrayList<Theater> theaters;

    public TheaterController() {
        theaters = new ArrayList<>();
    }

    public void add(Theater theater) {
        theaters.add(theater);
    }

    public Theater searchTheater(String location) {
        for (int i=0; i < theaters.size() ; i++) {
            if (theaters.get(i).getLocation().contains(location)) {
                return theaters.get(i);
            }
        }
        return null;
    }

    public int getTheaterID(String location) {
        if (searchTheater(location) != null)
            return searchTheater(location).getId();

        return -1;
    }

    public ArrayList<Theater> getTheaters() {
        return theaters;
    }


}
