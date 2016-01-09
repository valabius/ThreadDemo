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
                selectedDissertations.add(dissertation);
                count = 0;
            }
        }

        return selectedDissertations;

    }

    public static Dissertations sort(Dissertations dissertations, String[] keyWords) {

        int count = 0;
        Dissertation dissertation;
        Dissertations sortedDissertations = new Dissertations();

        int[] k = new int[keyWords.length];

        for (int i = 0; i < dissertations.size(); i++) {
            dissertations.get(i).setCount(0);
        }

        for(int i = 0; i < dissertations.size(); i++) {

            for (int j = 0; j < keyWords.length; j++) {
                if(dissertations.get(i).getTheme().indexOf(keyWords[j]) != -1) { count++; }
            }

            if(count > 0) {
                dissertations.get(i).setCount(count);
                count = 0;
            }
        }

        for (int i = 0; i < keyWords.length; i++) {
            for (int j = 0; j < dissertations.size(); j++) {
                if(dissertations.get(j).getCount() == (i + 1)) { k[i]++; }
            }
        }

        System.out.println(dissertations.size());
        for (int i = 0; i < k.length; i++) {
            System.out.println("" + (i + 1) + " - " + k[i]);
        }

        for (int i = keyWords.length; i > -1; i--) {
            for (int j = 0; j < dissertations.size(); j++) {
                if(dissertations.get(j).getCount() == i) { sortedDissertations.add(dissertations.get(j)); }
            }
        }
        return sortedDissertations;
    }

    public static Dissertations makeHighLightedDissertations(Dissertations dissertations, String[] keyWords, String htmlColor ) {

        String theme;
        Dissertations highLightedDissertations = new Dissertations();

        for (int i = 0; i < dissertations.size(); i++) {

            theme = dissertations.get(i).getTheme();

            for (int j = 0; j < keyWords.length; j++) {
                theme = theme.replaceAll(keyWords[j], "<b><font color=\"" + htmlColor + "\">" + keyWords[j] + "</font></b>");
            }

            highLightedDissertations.add(new Dissertation(dissertations.get(i).getAuthor(), theme, dissertations.get(i).getYear(),
                    dissertations.get(i).getCount(), dissertations.get(i).getUrl()));
        }

        return highLightedDissertations;
    }

}