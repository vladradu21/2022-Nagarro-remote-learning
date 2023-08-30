package com.nagarro.rl.week15.p3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileCompressorTest {
    private File inputFile;
    private File compressedFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create input file with some content
        inputFile = new File("input.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write(" This is some test content. This is some test content. This is some test content. This is some");
        }

        // Create compressed file
        compressedFile = new File("compressed.gz");
        FileCompressor.compressFile(inputFile, compressedFile);
    }

    @Test
    public void testCompressionRatio() {
        double expectedCompressionRatio = 0.5;
        double actualCompressionRatio = FileCompressor.getCompressionRatio(inputFile, compressedFile);

        assertEquals(expectedCompressionRatio, actualCompressionRatio, 0.1);
    }
}