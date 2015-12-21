package com.disser.reader;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;

import java.io.*;

public class ReaderFromFile {

    public static Dissertations ReadFromFile(String fileName) throws IOException {

        Dissertations dissertations = new Dissertations();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String s = "";
        String[] row;

        while((s = br.readLine()) != null) {
            row = s.split(";");
            dissertations.add(new Dissertation(row[0], row[1], row[2], 0, row[4]));
        }
        br.close();

        return dissertations;

    }

}
