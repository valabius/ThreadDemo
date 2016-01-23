package com.disser.factories;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

//lib.ua-ru.net
public class UaDissertationsFactory5 extends DissertationsFactory {

    Document document;
    Elements trs;
    Dissertations dissertations = new Dissertations();
    String author;
    String theme;

    @Override
    public Dissertations getAllDissertations() throws IOException {

        document = Jsoup.parse(new File("D:/index7.html"), "utf-8");
        trs = document.select("table").get(8).select("tbody").get(0).select("tr");

        for (int i = 0; i < trs.size(); i++) {
            if (trs.get(i).select("a[title=\"Пошук за шифром\"]").size() == 1) {
                author = trs.get(i).select("td").get(1).select("a").get(0).text();
                theme = trs.get(i).select("td").get(1).select("b").get(0).text();
                dissertations.add(new Dissertation(author, theme, "2015", 0, ""));
            }
        }

        return dissertations;

    }

}
