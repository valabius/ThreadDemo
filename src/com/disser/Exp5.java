package com.disser;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class Exp5 {

    public static void main(String[] args) throws IOException {

        Document document;
        Elements trs;
        String author;
        String theme;
        Dissertations dissertations = new Dissertations();

        document = Jsoup.parse(new File("D:/index7.html"), "utf-8");
        //document = Jsoup.connect("http://www.irbis-nbuv.gov.ua/cgi-bin/irbis64r_81/cgiirbis_64.exe?C21COM=S&I21DBN=REF&P21DBN=REF&S21FMT=fullw&S21ALL=%28%3C%2E%3ERZN%3D%D0%92%24%3C%2E%3E%29%2A%28%3C%2E%3EKNS%3D13%2E00%2E02%24%3C%2E%3E%29%2A%28%3C%2E%3EG%3D2015%3C%2E%3E%5B%2E%2E%2E%5D%3C%2E%3EG%3D2015%3C%2E%3E%29&FT_REQUEST=&FT_PREFIX=&Z21ID=&S21STN=1&S21REF=10&S21CNR=20").get();

        trs = document.select("table").get(8).select("tbody").get(0).select("tr");

        for (int i = 0; i < trs.size(); i++) {
            if (trs.get(i).select("a[title=\"Пошук за шифром\"]").size() == 1) {
                author = trs.get(i).select("td").get(1).select("a").get(0).text();
                theme = trs.get(i).select("td").get(1).select("b").get(0).text();
                dissertations.add(new Dissertation(author, theme, "2015", 0, ""));
            }
        }
        System.out.println(dissertations.size());

    }

}
