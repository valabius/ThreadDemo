package com.disser;

import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;


public class DisserMakerToTXT {

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

        WriterToFile.printToFile(someDissertations, "D:/disser.txt");

    }

}
