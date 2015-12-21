package com.exp;

import java.io.*;

public class Exp15 {
    public static void main(String[] args) throws IOException {

        String str1 = "aaaaa, bbbbb, ccccc";


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D:/test.txt")));
        bufferedWriter.write(str1);
        bufferedWriter.newLine();
        bufferedWriter.close();

        FileReader fr = new FileReader("D:/test.txt");
        BufferedReader br = new BufferedReader(fr);

        String s;
        String[] table;

        while((s = br.readLine()) != null) {
            table = s.split(", ");
        }

        fr.close();
    }
}
