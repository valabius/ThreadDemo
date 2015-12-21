package com.disser;

import com.disser.builders.DisserBuilder;
import com.disser.builders.DisserDirector;
import com.disser.builders.HTMLDisserBuilder;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;



public class DisserMakerToHTML {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "физи", "экспер", "виртуал", "комп", "модел" };

        Dissertations selectedDissertations;
        Dissertations someDissertations = new Dissertations();

        DissertationsFactory dissertationsFactory = FactoryProducer.getFactory("SelectedDissertationsFactory");
        selectedDissertations = dissertationsFactory.getSelectedDissertations(keyWords);

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

        WriterToFile.writeToFile(htmlDisser, "D:/disser5.html");

    }

}
