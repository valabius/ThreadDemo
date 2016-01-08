package com.disser;

import com.disser.builders.Client;
import com.disser.dissers.Disser;
import com.disser.dissertation.Dissertations;
import com.disser.filter.Filter;
import com.disser.reader.ReaderFromFile;
import com.disser.writer.WriterToFile;

import java.io.IOException;

public class HighLightedSelectedDisserMakerFromFile {

    public static void main(String[] args) throws IOException {

        String[] keyWords = { "����", "�����", "�������", "��������", "�������", "������", "�����", "�����", "����", "����" };
        //String[] keyWords5 = { "�������", "������", "�����", "��������" };
        String[] keyWords5 = { "������", "�������", "������", "�����", "��������" };

        Dissertations allDissertations = ReaderFromFile.ReadFromFile("D:/dissertations.txt");
        Dissertations dissertationsKeyWords = Filter.find(allDissertations, keyWords);
        Dissertations dissertationsKeyWords5 = Filter.find(dissertationsKeyWords, keyWords5);

        Dissertations sortedDissertations = Filter.sort(dissertationsKeyWords5, keyWords5);
        Dissertations highLighterDissertations = Filter.makeHighLightedDissertations(sortedDissertations, keyWords, keyWords5);

        Client client = new Client();
        Disser htmlDisser = client.getDisser(highLighterDissertations);

        WriterToFile.writeDisserToFile(htmlDisser, "D:/HighLighted selected dissertations.html");

    }

}
