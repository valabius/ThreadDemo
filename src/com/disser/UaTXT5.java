package com.disser;

import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;
import com.disser.writer.WriterToFile;

import java.io.IOException;


public class UaTXT5 {

    public static void main(String[] args) throws IOException {

        DissertationsFactory allDissertationsFactory5 = FactoryProducer.getFactory("UaDissertationsFactory5");
        Dissertations allDissertations = allDissertationsFactory5.getAllDissertations();

        System.out.println(allDissertations.size());

        WriterToFile.writeDissertationsToFile(allDissertations, "D:/Ukrainian dissertations (irbis-nbuv.gov.ua).txt");

    }

}
