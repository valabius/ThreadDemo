package com.disser.factories;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

//dslib.net
public class RuDissertationsFactory5 extends DissertationsFactory {

    Document document;
    Elements elements;
    Element table;
    Elements trs;
    Iterator<Element> iterator;
    Element tr;
    Elements tds;
    int count = 0;
    Dissertations dissertations = new Dissertations();
    Elements links;
    String url;

    boolean t = true;
    String address;
    String firstAddress = "http://www.dslib.net/teoria-vospitania.html";
    String addressWithSuffix = "http://www.dslib.net/teoria-vospitania--p-";

    @Override
    public Dissertations getAllDissertations() throws IOException {

        for (int i = 1; i < 192; i++) {

            System.out.println(i);

            if(t) {
                address = firstAddress; t = false;
            } else { address = addressWithSuffix + i + ".html"; }

            document = Jsoup.connect(address).get();

            elements = document.select("table");
            table = elements.get(22);
            trs = table.select("tr");
            iterator = trs.iterator();

            while(iterator.hasNext()) {

                tr = iterator.next();
                tds = tr.select("td");
                links = tds.select("a[href]");
                url = links.get(0).attr("abs:href");
                dissertations.add(new Dissertation(tds.get(1).text(), tds.get(0).text(), tds.get(2).text(), count, url));

            }
        }

        return dissertations;
    }

}
