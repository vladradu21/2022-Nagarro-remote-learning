package com.nagarro.rl.week15.p4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class UTF8ToLatin1Transcoder {
    public static void transcodeUTF8ToLatin1(String inputFile, String outputFile, String errorFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.ISO_8859_1));
             BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorFile))) {

            int c;
            while ((c = reader.read()) != -1) {
                try {
                    writer.write((char) c);
                } catch (IOException e) {
                    errorWriter.write(Integer.toHexString(c).toUpperCase());
                    errorWriter.newLine();
                }
            }
        }
    }
}
