package com.disser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Exp15 {
    public static void main(String[] args) throws IOException {

        String s = "http://www.lib.ua-ru.net/diss/cont/515908.html";
        String str = "AAAAA";
        String table = "<tr>\n" +
                "<td class=\"content1\"><a href=\"" + s + "\">" + str + "</a></td>\n" +
                "<td class=\"content1\"><a href=\"" + s + "\">" + str + "</a></td>\n" +
                "<td width=\"10\" class=\"content1\">" + str + "</a></td>\n" +
                "</tr>\n";
        System.out.println(table);
    }
}
