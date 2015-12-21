package com.exp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class WriteToFile {

    private static String before = "<!DOCTYPE HTML>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <meta charset=\"utf-8\">\n" +
            "        <title>Disser</title>\n" +
            "        <link rel=\"stylesheet\" type=\"text/css\" href=\"lib_new.css\">\n" +
            "    </head>\n" +
            "    <body>\n";
    private static String after = "\n    </body>\n" +
            "</html>";

    private static String prepareTable(LinkedList<Dissertation> dissertations) {
        String str;
        String table = "";
        String tableBefore = "<table  width=\"70%\" border=\"0\" align=\"center\">\n";
        String tableAfter = "</table>\n";

        for (int i = 0; i < dissertations.size(); i++) {
            table = table + "<tr>\n" +
                    "<td class=\"content1\"><a href=\"" + dissertations.get(i).getUrl() + "\">" + dissertations.get(i).getAuthor() + "</a></td>\n" +
                    "<td class=\"content1\"><a href=\"" + dissertations.get(i).getUrl() + "\">" + dissertations.get(i).getTheme() + "</a></td>\n" +
                    "<td width=\"10\" class=\"content1\">" + dissertations.get(i).getYear() + "</a></td>\n" +
                    "<td width=\"10\" class=\"content1\">" + dissertations.get(i).getCount() + "</a></td>\n" +
                    "</tr>\n";
        }

        str = tableBefore + table + tableAfter;

        return str;
    }

    public static void writeToFile(LinkedList<Dissertation> dissertations, String file) throws IOException {

        String html = before + prepareTable(dissertations) + after;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(file)));
        bufferedWriter.write(html);
        bufferedWriter.close();
    }

}
