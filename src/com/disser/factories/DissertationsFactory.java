package com.disser.factories;

import com.disser.dissertation.Dissertations;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

abstract public class DissertationsFactory {

   abstract public Dissertations getAllDissertations() throws IOException;

}
