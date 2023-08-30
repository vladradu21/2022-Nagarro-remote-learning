package com.nagarro.rl.week15.p4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Latin1ToUTF8TranscoderTest {
    private File inputFile;
    private File outputFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create input file with some content encoded in Latin1
        inputFile = new File("input-latin1.txt");
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(inputFile), StandardCharsets.ISO_8859_1)) {
            writer.write("This is some test content in Latin1 encoding.");
        }

        // Transcode input file from Latin1 to UTF-8 and save to output file
        outputFile = new File("output-utf8.txt");
        Latin1ToUTF8Transcoder.transcodeLatin1ToUTF8(inputFile.getPath(), outputFile.getPath());
    }

    @Test
    public void testTranscodeLatin1ToUTF8() throws IOException {
        // Read output file and check if the content is the same as the original Latin1-encoded content
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile), StandardCharsets.UTF_8))) {
            String actualContent = reader.readLine();
            assertEquals("This is some test content in Latin1 encoding.", actualContent);
        }
    }
}
