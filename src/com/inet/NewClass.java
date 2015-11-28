package com.inet;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;


public class NewClass {
    public static void main(String[] args) throws IOException {
        String result = doPost();
        writeToFile(result);
        System.out.println(result);
    }

    public  static  String doPost() throws IOException {
        URL url = new URL("http://nomer.ws/allukraina/");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print("lastName");
        out.print('=');
        out.print(URLEncoder.encode("Хомяк", "UTF-8"));

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