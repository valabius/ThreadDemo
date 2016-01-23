package com.disser;

import com.disser.builders.Client;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.filter.Filter;
import com.disser.reader.ReaderFromFile;
import com.disser.writer.WriterToFile;

import java.io.IOException;

//lib.ua-ru.net
public class RuHTML {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "физи", "механ", "молекул", "термодин", "электр", "магнит", "оптик", "квант", "атом", "ядер" };
        String[] keyWords5 = { "экспер", "виртуал", "компью", "модел", "информац" };
        String[] keyWords15 = { "экспер"};

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/Russian dissertations (lib.ua-ru.net).txt");
        Dissertations dissertationsKeyWords = Filter.find(allDissertations, keyWords);
        Dissertations dissertationsKeyWords5 = Filter.find(dissertationsKeyWords, keyWords5);

        Dissertations sortedDissertations = Filter.sort(dissertationsKeyWords5, keyWords5);
        Dissertations highLighterDissertations = Filter.makeHighLightedDissertations(sortedDissertations, keyWords, "green");
        highLighterDissertations = Filter.makeHighLightedDissertations(highLighterDissertations, keyWords5, "red");
        highLighterDissertations = Filter.makeHighLightedDissertations(highLighterDissertations, keyWords15, "blue");

        Client client = new Client();
        Disser htmlDisser = client.getDisser(highLighterDissertations, "Ru (lib.ua-ru.ru)");

        WriterToFile.writeDisserToFile(htmlDisser, "D:/Ru (lib.ua-ru.ru).html");

    }

}
