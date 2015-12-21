package com.disser.builders;

import com.disser.dissers.Disser;

public class DisserDirector {

    private DisserBuilder disserBuilder;

    public void setDisserBuilder(DisserBuilder hdb) { disserBuilder = hdb; }
    public Disser getDisser() { return disserBuilder.getDisser(); }

    public void constractDisser() {

        disserBuilder.createNewDisserProduct();
        disserBuilder.buildHeader();
        disserBuilder.buildTable();
        disserBuilder.buildFooter();
    }

}
