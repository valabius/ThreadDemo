package com.disser.builders;

import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;

abstract public class DisserBuilder {

    protected Disser disser;
    protected Dissertations dissertations;

    public DisserBuilder(Dissertations drs, String tl) {
        dissertations = drs;
    }

    public Disser getDisser() { return disser; }
    public void createNewDisserProduct() {}

    public abstract void buildHeader();
    public abstract void buildTable();
    public abstract void buildFooter();

}
