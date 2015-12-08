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

        int count = 0;
        String[] str = { "физи", "экспер", "виртуал", "комп", "модел" };

        String string = "Методика использования учебных понятийных комплексов в условиях развивающего обучения физике в ВУЗе".toLowerCase();

        for (int i = 0; i < 5; i++) {
            if(string.indexOf(str[i]) != -1) { count++; }
        }
        System.out.println(string);
        System.out.println(string.indexOf("физи"));

    }
}
