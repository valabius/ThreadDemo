package com.disser.factories;


import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import org.jsoup.Jsoup;

import java.io.IOException;


public class SelectedDissertationsFactory extends DissertationsFactory {

    @Override
    public Dissertations getAllDissertations() {
        return null;
    }

    @Override
    public Dissertations getSelectedDissertations(String[] keyWords) throws IOException {

        this.keyWords = keyWords;

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
                    if(tds.get(1).text().indexOf(keyWords[j]) != -1) { count++; }
                }
                if(count > 0) {
                    links = tds.select("a[href]");
                    url = links.get(1).attr("abs:href");
                    dissertations.add(new Dissertation(tds.get(0).text(), tds.get(1).text(), tds.get(2).text(), count, url));
                    count = 0;
                }

            }
        }

        return dissertations;
    }
}
