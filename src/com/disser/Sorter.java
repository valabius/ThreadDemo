package com.disser;


import java.util.LinkedList;

public class Sorter {

    public static LinkedList<Dissertation> sortDisertations(LinkedList<Dissertation> dissertations) {

        Dissertation dissertation;

        for (int i = 0; i < dissertations.size() - 1; i++) {
            for (int j = 0; j < dissertations.size() - i - 1; j++) {
                if(dissertations.get(j).getCount() > dissertations.get(j+1).getCount()) {
                    dissertation = dissertations.get(j);
                    dissertations.set(j, dissertations.get(j+1));
                    dissertations.set(j + 1, dissertation);
                }
            }
        }
        return dissertations;
    }
}
