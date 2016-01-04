package com.disser.builders;

import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;

public class Client {

    public Disser getDisser(Dissertations dissertations) {

        DisserBuilder htmlDisserBuilder = new HTMLDisserBuilder(dissertations);
        DisserDirector disserDirector = new DisserDirector();
        disserDirector.setDisserBuilder(htmlDisserBuilder);
        disserDirector.constractDisser();
        Disser htmlDisser = disserDirector.getDisser();

        return htmlDisser;
    }

}
