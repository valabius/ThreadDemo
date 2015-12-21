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

public class AllDisserMakerFromFile {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "экспер", "виртуал", "комп", "модел" };
        String[] keyWords5 = { "физи", "механ", "молекул", "термодин", "элктр", "магнит", "квант", "атом", "ядер" };

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/dissertations.txt");
        Dissertations selectedDissertations = Finder.find(allDissertations, keyWords);
        Dissertations someDissertations = new Dissertations();

        for (int i = 0; i < selectedDissertations.size(); i++) {

            if(selectedDissertations.get(i).getCount() == 4) { someDissertations.add(selectedDissertations.get(i)); }
        }

        for (int i = 0; i < selectedDissertations.size(); i++) {

            if(selectedDissertations.get(i).getCount() == 3) { someDissertations.add(selectedDissertations.get(i)); }
        }

        DisserBuilder htmlDisserBuilder = new HTMLDisserBuilder(someDissertations);
        DisserDirector disserDirector = new DisserDirector();
        disserDirector.setDisserBuilder(htmlDisserBuilder);
        disserDirector.constractDisser();
        Disser htmlDisser = disserDirector.getDisser();

        WriterToFile.writeToFile(htmlDisser, "D:/Some dissertations.html");

    }

}
