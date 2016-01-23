package com.disser;

import com.disser.builders.Client;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.filter.Filter;
import com.disser.reader.ReaderFromFile;
import com.disser.writer.WriterToFile;

import java.io.IOException;

//lib.ua-ru.net
public class UaHTML {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "фізи", "механ", "молекул", "термодин", "електр", "магніт", "оптик", "квант", "атом", "ядер" };
        String[] keyWords5 = { "експер", "віртуал", "комп'ю", "модел", "інформац" };
        String[] keyWords15 = { "експер"};

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/Ukrainian dissertations (lib.ua-ru.net).txt");
        Dissertations dissertationsKeyWords = Filter.find(allDissertations, keyWords);
        Dissertations dissertationsKeyWords5 = Filter.find(dissertationsKeyWords, keyWords5);

        Dissertations sortedDissertations = Filter.sort(dissertationsKeyWords5, keyWords5);
        Dissertations highLighterDissertations = Filter.makeHighLightedDissertations(sortedDissertations, keyWords, "green");
        highLighterDissertations = Filter.makeHighLightedDissertations(highLighterDissertations, keyWords5, "red");
        highLighterDissertations = Filter.makeHighLightedDissertations(highLighterDissertations, keyWords15, "blue");

        Client client = new Client();
        Disser htmlDisser = client.getDisser(highLighterDissertations, "Ua (lib.ua-ru.ru)");

        WriterToFile.writeDisserToFile(htmlDisser, "D:/Ua (lib.ua-ru.ru).html");

    }

}
