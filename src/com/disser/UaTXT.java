package com.disser;

import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;


public class UaTXT {

    public static void main(String[] args) throws IOException {

        DissertationsFactory allDissertationsFactory = FactoryProducer.getFactory("UaDissertationsFactory");
        Dissertations allDissertations = allDissertationsFactory.getAllDissertations();

        System.out.println(allDissertations.size());

        WriterToFile.writeDissertationsToFile(allDissertations, "D:/Ukrainian dissertations (lib.ua-ru.net).txt");

    }

}
