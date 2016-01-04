package com.disser;

import com.disser.builders.Client;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.filter.Filter;
import com.disser.reader.ReaderFromFile;
import com.disser.writer.WriterToFile;

import java.io.IOException;

public class SelectedDisserMakerFromFile {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "физи", "механ", "молекул", "термодин", "электри", "магнит", "квант", "атом", "ядер" };
        String[] keyWords5 = { "экспер", "виртуал", "комп", "модел", "информац", "ИКТ" };

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/dissertations.txt");
        Dissertations dissertationsKeyWords = Filter.find(allDissertations, keyWords);
        Dissertations dissertationsKeyWords5 = Filter.find(dissertationsKeyWords, keyWords5);

        Dissertations selectedDissertations = Filter.sort(dissertationsKeyWords5, keyWords5);

        Client client = new Client();
        Disser htmlDisser = client.getDisser(selectedDissertations);

        WriterToFile.writeDisserToFile(htmlDisser, "D:/Selected dissertations.html");

    }

}
