package com.disser.builders;

import com.disser.dissers.HTMLDisser;
import com.disser.dissertation.Dissertations;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class HTMLDisserBuilder extends DisserBuilder {

    private String header;

    private String footer;

    public HTMLDisserBuilder(Dissertations drs, String tl) {
        super(drs, tl);
        header =
                "<!DOCTYPE HTML>\n" +
                        "<html>\n" +
                        "   <head>\n" +
                        "       <meta charset=\"utf-8\">\n" +
                        "       <title>" + tl + "</title>\n" +
                        "       <link rel=\"stylesheet\" type=\"text/css\" href=\"lib_new.css\">\n" +
                        "   </head>\n" +
                        "   <body>\n";

        footer =
                "   </body>\n" +
                        "</html>";
    }

    @Override
    public void createNewDisserProduct() {
        disser = new HTMLDisser();
    }

    @Override
    public void buildHeader() {
        disser.setHeader(header);
    }

    @Override
    public void buildTable() {
        String table;
        String beforeTable = "      <table width=\"70%\" border=\"0\" align=\"center\">\n";
        String middleTable = "";
        String afterTable = "       </table>\n";

        for (int i = 0; i < dissertations.size(); i++) {
            middleTable = middleTable +
                "           <tr>\n" +
                "               <td class=\"content1\"><a href=\"" + dissertations.get(i).getUrl() + "\">" + dissertations.get(i).getAuthor() + "</a></td>\n" +
                "               <td class=\"content1\"><a href=\"" + dissertations.get(i).getUrl() + "\">" + dissertations.get(i).getTheme() + "</a></td>\n" +
                "               <td width=\"10\" class=\"content1\">" + dissertations.get(i).getYear() + "</a></td>\n" +
                "               <td width=\"10\" class=\"content1\">" + dissertations.get(i).getCount() + "</a></td>\n" +
                "           </tr>\n";

        }

        table = beforeTable + middleTable + afterTable;

        disser.setTable(table);
    }

    @Override
    public void buildFooter() {
        disser.setFooter(footer);
    }
}
