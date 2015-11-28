package com.inet;

import java.io.*;
import java.net.*;
import java.util.*;

public class URLIrbis {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.irbis-nbuv.gov.ua/cgi-bin/irbis64r_81/cgiirbis_64.exe?C21COM=F&I21DBN=ARD_EX&P21DBN=ARD&S21CNR=20&Z21ID=");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("aaaaa", "aaaaa");
            Map<String, List<String>> headers = connection.getRequestProperties();
            System.out.println(headers);
            connection.connect();
            headers = connection.getHeaderFields();
            System.out.println(headers);
/*            InputStream in = connection.getInputStream();
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }*/
        } catch (IOException e) {e.printStackTrace();}
    }
}
