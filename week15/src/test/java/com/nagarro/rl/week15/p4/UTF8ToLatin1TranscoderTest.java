package com.nagarro.rl.week15.p4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UTF8ToLatin1TranscoderTest {
    private static final String INPUT_FILE = "input_utf8.txt";
    private static final String OUTPUT_FILE = "output_latin1.txt";
    private static final String ERROR_FILE = "error.txt";

    @Test
    public void testTranscodeUTF8ToLatin1() throws IOException {
        // Set up input file with UTF-8 encoding
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(INPUT_FILE), StandardCharsets.UTF_8))) {
            writer.write("This is some test content with UTF-8 characters: é");
        }

        // Transcode UTF-8 input file to Latin1 output file
        UTF8ToLatin1Transcoder.transcodeUTF8ToLatin1(INPUT_FILE, OUTPUT_FILE, ERROR_FILE);

        // Verify that output file has correct content
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(OUTPUT_FILE), StandardCharsets.ISO_8859_1))) {
            String line = reader.readLine();
            assertEquals("This is some test content with UTF-8 characters: ?", line);
        }

        // Verify that error file has correct content
        try (BufferedReader reader = new BufferedReader(new FileReader(ERROR_FILE))) {
            String line = reader.readLine();
            assertEquals("C3", line);
        }
    }
}
