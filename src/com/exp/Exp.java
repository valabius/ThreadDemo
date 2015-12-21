package com.exp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exp {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("http://www.lib.ua-ru.net/disser/ru/code-13.00.02--p-1.html").get();
        Elements elements = document.select("table");
        Element element = elements.get(20);

        String table = element.html();

        String before = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <title>Disser</title>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"lib_new.css\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "    <table  width=\"70%\" border=\"0\" align=\"center\">\n";
        String after = "\n    </table>\n" +
                "\n    </body>\n" +
                "</html>";

        String string = before + table + after;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D:/disser.html")));
        bufferedWriter.write(string);
        bufferedWriter.close();

        //System.out.println(string);
        System.out.println("OK");
    }
}
