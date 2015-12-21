package com.disser.dissers;

public class TXTDisser implements Disser {

    private String table;

    public void setHeader(String header) {}

    public void setTable(String table) {
        this.table = table;
    }

    public void setFooter(String footer) {}

    @Override
    public String toString() {
        return (table);
    }
}
