package com.disser.dissers;

public class HTMLDisser implements Disser {

    private String header;
    private String table;
    private String footer;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {

        return (header + table + footer);

    }
}
