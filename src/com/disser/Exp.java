package com.disser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class Exp {

    public static void main(String[] args) throws IOException {

        Document document;
        Element element;
        Element td;
        Element hr;
        Elements elements;
        Elements trs;
        Elements tds;
        Elements hrs;
        String author;
        String theme;
        String url;

        File file = new File("D:/index17.html");
        document = Jsoup.parse(file, "utf-8");

        //elements = document.select("table").get(8).select("tbody").get(0).select("tr").get(7).select("td").get(1).select("a");

        trs = document.select("table").get(8).select("tbody").get(0).select("tr");

        int k = 1;
        for (int i = 0; i < trs.size(); i++) {
            if (trs.get(i).select("a[title=\"Пошук за шифром\"]").size() == 1) {
                author = trs.get(i).select("td").get(1).select("a").get(0).text();
                theme = trs.get(i).select("td").get(1).select("b").get(0).text();
                url = trs.get(i).select("td").get(1).select("a[href]").get(1).attr("href");
                System.out.println(k + "." + author + "   " + theme + "   " + url);
                k++;
            }
        }

    }

}
