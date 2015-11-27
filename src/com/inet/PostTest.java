package com.inet;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;


public class PostTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        InputStream in = Files.newInputStream(Paths.get("config.properties"));
        props.load(in);
        String url = props.remove("url").toString();
        String result = doPost(url, props);
        writeToFile(result);
        System.out.println(result);
    }

    public  static  String doPost(String urlString, Map<Object, Object> nameValuesPairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        boolean first = true;
        for(Map.Entry<Object, Object> pair : nameValuesPairs.entrySet()) {
            if (first) first = false;
            else out.print('&');
            String name = pair.getKey().toString();
            String value = pair.getValue().toString();
            out.print(name);
            out.print('=');
            out.print(URLEncoder.encode(value, "UTF-8"));
        }

        StringBuilder response = new StringBuilder();
        try {
            Scanner in = new Scanner(connection.getInputStream());

            while (in.hasNextLine()) {
                response.append(in.nextLine());
                response.append("\n");
            }

        } catch(IOException e) {
            if(!(connection instanceof  HttpURLConnection)) throw e;
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if(err == null) throw e;
            Scanner in = new Scanner(err);
            response.append(in.nextLine());
            response.append("\n");
        }
        return response.toString();
    }

    public static void writeToFile(String str) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D:/nomer.html")));
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {e.printStackTrace();}
    }

}