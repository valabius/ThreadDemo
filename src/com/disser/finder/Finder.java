package com.disser.finder;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;

import java.util.Iterator;

public class Finder {

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

}