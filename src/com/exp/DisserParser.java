package com.exp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class DisserParser {
    public static void main(String[] args) throws IOException {

        String[] str = { "физи", "экспер", "виртуал", "комп", "модел" };
        Document document;
        Elements elements;
        Element table;
        Elements trs;
        Iterator<Element> iterator;
        Element tr;
        Elements tds;
        int count = 0;
        LinkedList<Dissertation> dissertations = new LinkedList<Dissertation>();
        Elements links;
        String url;

        boolean t = true;
        String address;
        String firstAddress = "http://www.lib.ua-ru.net/disser/ru/code-13.00.02.html";
        String addressWithSuffix = "http://www.lib.ua-ru.net/disser/ru/code-13.00.02--p-";

        for (int i = 0; i < 151; i++) {

            System.out.println(i);

            if(t) {
                address = firstAddress; t = false;
            } else { address = addressWithSuffix + i + ".html"; }

            document = Jsoup.connect(address).get();
            elements = document.select("table");
            table = elements.get(20);
            trs = table.select("tr");
            iterator = trs.iterator();

            while(iterator.hasNext()) {
                tr = iterator.next();
                tds = tr.select("td");

                for (int j = 0; j < 5; j++) {
                    if(tds.get(1).text().indexOf(str[j]) != -1) { count++; }
                }
                if(count > 0) {
                    links = tds.select("a[href]");
                    url = links.get(1).attr("abs:href");
                    dissertations.add(new Dissertation(tds.get(0).text(), tds.get(1).text(), tds.get(2).text(), count, url));
                    count = 0;
                }

            }
        }

        for (Dissertation d : dissertations) {
            System.out.println(d);
        }

        LinkedList<Dissertation> selectedDissertations = new LinkedList<Dissertation>();

        for (int i = 0; i < dissertations.size(); i++) {

            if(dissertations.get(i).getCount() == 4) { selectedDissertations.add(dissertations.get(i)); }
        }

        for (int i = 0; i < dissertations.size(); i++) {

            if(dissertations.get(i).getCount() == 3) { selectedDissertations.add(dissertations.get(i));  }
        }

        WriteToFile.writeToFile(selectedDissertations, "D:/disser5.html");

    }
}