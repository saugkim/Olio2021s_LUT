package org.lut.week9;

import java.util.ArrayList;

public class TheaterController {

    ArrayList<Theater> theaters;
    public static int DEFAULT_AREA_CODE = 1029;

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

        return DEFAULT_AREA_CODE;
    }

    public ArrayList<Theater> getTheaters() {
        return theaters;
    }


}
