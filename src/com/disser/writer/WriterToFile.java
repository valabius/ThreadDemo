package com.disser.writer;

import com.disser.dissertation.Dissertation;
import com.disser.dissertation.Dissertations;
import com.disser.dissers.Disser;

import java.io.*;

public class WriterToFile {

    public static void writeDisserToFile(Disser disser, String fileName) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write(disser.toString());
        bufferedWriter.close();

    }

    public static void writeDissertationsToFile(Dissertations dissertations, String fileName) throws IOException {

        PrintWriter printWriter = new PrintWriter(new File(fileName));

        for (Dissertation dissertation : dissertations) {
            printWriter.println(dissertation);
        }

        printWriter.close();

    }

    public static void writeToFile(String str, String fileName) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write(str);
        bufferedWriter.close();

    }

}
