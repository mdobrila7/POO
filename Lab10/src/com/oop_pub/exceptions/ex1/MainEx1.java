package com.oop_pub.exceptions.ex1;

import java.io.*;

public class MainEx1 {
    private static void readAndPrintLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String line = reader.readLine();
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            writer.close();
        }
    }

    public static void main(String[] args) {
        try {
            readAndPrintLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
