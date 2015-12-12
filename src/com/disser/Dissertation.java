package com.disser;

public class Dissertation {

    private String author;
    private String theme;
    private String year;
    private int count;
    private String url;

    public Dissertation(String author, String theme, String year, int count, String url) {
        this.author = author;
        this.theme = theme;
        this.year = year;
        this.count = count;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return author + " " + theme + " " + year + " " + count;
    }
}
