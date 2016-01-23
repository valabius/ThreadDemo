package com.disser;

import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;


public class RuTXT {

    public static void main(String[] args) throws IOException {

        DissertationsFactory allDissertationsFactory = FactoryProducer.getFactory("RuDissertationsFactory");
        Dissertations allDissertations = allDissertationsFactory.getAllDissertations();

        System.out.println(allDissertations.size());

        WriterToFile.writeDissertationsToFile(allDissertations, "D:/Russian dissertations (lib.ua-ru.net).txt");

    }

}
