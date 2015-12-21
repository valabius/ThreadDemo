package com.disser.builders;

import com.disser.dissers.TXTDisser;
import com.disser.dissertation.Dissertations;

public class TXTDisserBuilder extends DisserBuilder {

    public TXTDisserBuilder(Dissertations drs) {
        super(drs);
    }

    @Override
    public void createNewDisserProduct() {
        disser = new TXTDisser();
    }

    @Override
    public void buildHeader() {}

    @Override
    public void buildTable() {

        String table = "";

        for (int i = 0; i < dissertations.size(); i++) {
            table = table + dissertations.get(i).toString();
        }

        disser.setTable(table);

    }

    @Override
    public void buildFooter() {}

}
