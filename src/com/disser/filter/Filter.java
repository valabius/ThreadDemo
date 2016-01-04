package com.disser.filter;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;

import java.util.Iterator;

public class Filter {

    public static Dissertations find(Dissertations dissertations, String[] keyWords) {

        int count = 0;
        Dissertation dissertation;
        Dissertations selectedDissertations = new Dissertations();
        Iterator<Dissertation> iterator = dissertations.iterator();

        while(iterator.hasNext()) {

            dissertation = iterator.next();

            for (int j = 0; j < keyWords.length; j++) {
                if(dissertation.getTheme().indexOf(keyWords[j]) != -1) { count++; }
            }

            if(count > 0) {
                dissertation.setCount(count);
                selectedDissertations.add(dissertation);
                count = 0;
            }
        }

        return selectedDissertations;

    }

    public static Dissertations sort(Dissertations dissertations, String[] keyWords) {

        int[] k = new int[keyWords.length];

        Dissertations selectedDissertations = new Dissertations();

        for (int i = 0; i < keyWords.length; i++) {
            for (int j = 0; j < dissertations.size(); j++) {
                if(dissertations.get(j).getCount() == (i + 1)) { k[i]++; }
            }
        }

        System.out.println(dissertations.size());
        for (int i = 0; i < k.length; i++) {
            System.out.println("" + (i + 1) + " - " + k[i]);
        }

        for (int i = keyWords.length; i > 0; i--) {
            for (int j = 0; j < dissertations.size(); j++) {
                if(dissertations.get(j).getCount() == i) { selectedDissertations.add(dissertations.get(j)); }
            }
        }
        return selectedDissertations;
    }

}