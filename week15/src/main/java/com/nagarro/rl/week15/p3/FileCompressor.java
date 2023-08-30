package com.nagarro.rl.week15.p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class FileCompressor {
    public static void compressFile(File inputFile, File outputFile) throws IOException {
        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile);
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {

            byte[] buffer = new byte[8192];

            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                gzipOutputStream.write(buffer, 0, len);
            }
        }
    }

    public static double getCompressionRatio(File inputFile, File compressedFile) {
        long inputFileSize = inputFile.length();
        long compressedFileSize = compressedFile.length();
        double compressionRatio = (double) compressedFileSize / inputFileSize;
        System.out.println("Compression ratio: " + compressionRatio);
        return compressionRatio;
    }
}
