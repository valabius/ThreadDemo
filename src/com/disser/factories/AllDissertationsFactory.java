package com.disser.factories;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import org.jsoup.Jsoup;

import java.io.IOException;

public class AllDissertationsFactory extends DissertationsFactory {

    @Override
    public Dissertations getAllDissertations() throws IOException {

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
                links = tds.select("a[href]");
                url = links.get(1).attr("abs:href");
                dissertations.add(new Dissertation(tds.get(0).text(), tds.get(1).text(), tds.get(2).text(), count, url));

            }
        }

        return dissertations;
    }

    @Override
    public Dissertations getSelectedDissertations(String[] keyWords) {
        return null;
    }
}
