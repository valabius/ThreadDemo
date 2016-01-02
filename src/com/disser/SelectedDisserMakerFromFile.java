package com.disser;

import com.disser.builders.DisserBuilder;
import com.disser.builders.DisserDirector;
import com.disser.builders.HTMLDisserBuilder;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.finder.Finder;
import com.disser.reader.ReaderFromFile;
import com.disser.writer.WriterToFile;

import java.io.IOException;

public class SelectedDisserMakerFromFile {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "физи", "механ", "молекул", "термодин", "электри", "магнит", "квант", "атом", "ядер" };
        String[] keyWords5 = { "экспер", "виртуал", "комп", "модел", "информац", "ИКТ" };

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/dissertations.txt");
        Dissertations dissertationsKeyWords = Finder.find(allDissertations, keyWords);
        Dissertations dissertationsKeyWords5 = Finder.find(dissertationsKeyWords, keyWords5);

        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        int k4 = 0;
        int k5 = 0;
        int k6 = 0;

        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 1) { k1++; }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 2) { k2++; }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 3) { k3++; }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 4) { k4++; }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 5) { k5++; }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {
            if(dissertationsKeyWords5.get(i).getCount() == 6) { k6++; }
        }

        System.out.println(dissertationsKeyWords5.size());
        System.out.println("k1 = " + k1);
        System.out.println("k2 = " + k2);
        System.out.println("k3 = " + k3);
        System.out.println("k4 = " + k4);
        System.out.println("k5 = " + k5);
        System.out.println("k6 = " + k6);

        Dissertations selectedDissertations = new Dissertations();

        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 6) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 5) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 4) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 3) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 2) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }
        for (int i = 0; i < dissertationsKeyWords5.size(); i++) {

            if(dissertationsKeyWords5.get(i).getCount() == 1) { selectedDissertations.add(dissertationsKeyWords5.get(i)); }
        }

        DisserBuilder htmlDisserBuilder = new HTMLDisserBuilder(selectedDissertations);
        DisserDirector disserDirector = new DisserDirector();
        disserDirector.setDisserBuilder(htmlDisserBuilder);
        disserDirector.constractDisser();
        Disser htmlDisser = disserDirector.getDisser();

        WriterToFile.writeToFile(htmlDisser, "D:/Some dissertations5.html");

    }

}
