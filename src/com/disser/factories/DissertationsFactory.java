package com.disser.factories;

import com.disser.dissertation.Dissertations;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

abstract public class DissertationsFactory {

   String[] keyWords;
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
   String firstAddress = "http://www.lib.ua-ru.net/disser/ru/code-13.00.02.html";
   String addressWithSuffix = "http://www.lib.ua-ru.net/disser/ru/code-13.00.02--p-";

   abstract public Dissertations getAllDissertations() throws IOException;
   abstract public Dissertations getSelectedDissertations(String[] keyWords) throws IOException;

}
