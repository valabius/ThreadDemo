package com.disser;

import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;


public class RuTXT5 {

    public static void main(String[] args) throws IOException {

        DissertationsFactory allDissertationsFactory5 = FactoryProducer.getFactory("RuDissertationsFactory5");
        Dissertations allDissertations5 = allDissertationsFactory5.getAllDissertations();

        System.out.println(allDissertations5.size());

        WriterToFile.writeDissertationsToFile(allDissertations5, "D:/Russian dissertations (dslib.net).txt");

    }

}
