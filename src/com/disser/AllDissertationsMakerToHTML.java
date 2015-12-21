package com.disser;

import com.disser.builders.DisserBuilder;
import com.disser.builders.DisserDirector;
import com.disser.builders.HTMLDisserBuilder;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.factories.DissertationsFactory;
import com.disser.factories.FactoryProducer;

import java.io.IOException;


public class AllDissertationsMakerToHTML {

    public static void main(String[] args) throws IOException {

        DissertationsFactory allDissertationsFactory = FactoryProducer.getFactory("AllDissertationsFactory");
        Dissertations allDissertations = allDissertationsFactory.getAllDissertations();

        System.out.println(allDissertations.size());

        Dissertations subDissertations = new Dissertations();
        for (int i = 0; i < 1000; i++) {
            subDissertations.add(allDissertations.get(i));
        }

        DisserBuilder htmlDisserBuilder = new HTMLDisserBuilder(allDissertations);
        DisserDirector disserDirector = new DisserDirector();
        disserDirector.setDisserBuilder(htmlDisserBuilder);
        disserDirector.constractDisser();
        Disser htmlDisser = disserDirector.getDisser();

        System.out.println(htmlDisser);

        //WriterToFile.writeToFile(htmlDisser, "D:/dissertations15.html");

    }

}
