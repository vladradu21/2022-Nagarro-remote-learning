package com.nagarro.rl.week15.p2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
    private String filename;

    public RandomAccess(String filename) {
        this.filename = filename;
    }

    public void writeIntegers(int[] nums) throws IllegalArgumentException {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty");
        }
        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            for (int i = 0; i < nums.length; i++) {
                file.writeInt(nums[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int readThird() throws NumberNotFoundException {
        int result;

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            file.seek(2 * Integer.BYTES);
            result = file.readInt();
        } catch (IOException e) {
            throw new NumberNotFoundException("Failed to read third number");
        }

        return result;
    }

    public int readFourth() throws NumberNotFoundException {
        int result;

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            file.seek(3 * Integer.BYTES);
            result = file.readInt();
        } catch (IOException e) {
            throw new NumberNotFoundException("Failed to read fourth number");
        }

        return result;
    }
}
