package com.nagarro.rl.week5.p2;

import java.util.Arrays;

public class StringList implements List<String> {
    private String[] arrayOfElements;
    private int sizeOfArray;
    private StringBuilder operations;

    public StringList(String[] arrayOfElements, int sizeOfArray, StringBuilder operations) {
        this.arrayOfElements = arrayOfElements;
        this.sizeOfArray = sizeOfArray;
        this.operations = operations;
    }

    private void checkNullOrEmpty(String element) throws NullOrEmptyValueException {
        if (element == null || element.isEmpty()) {
            throw new NullOrEmptyValueException("Cannot add/search for null or empty value to the list.");
        }
    }

    private void checkNumeric(String element) throws NonNumericValueException {
        try {
            Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new NonNumericValueException("Cannot add/search for non-numeric value to the list.");
        }
    }

    @Override
    public void add(String element) throws NullOrEmptyValueException, NonNumericValueException {
        checkNullOrEmpty(element);
        checkNumeric(element);

        if(sizeOfArray == arrayOfElements.length) {
            arrayOfElements = Arrays.copyOf(arrayOfElements, sizeOfArray * 2);
        }

        arrayOfElements[sizeOfArray++] = element;
        operations.append("Added: " + element + "\n");
    }

    @Override
    public String get(int position) throws ArrayIndexOutOfBoundsException {
        if (position < 0 || position >= sizeOfArray) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        operations.append("Retrieved: " + arrayOfElements[position] + "\n");
        return arrayOfElements[position];
    }

    @Override
    public boolean contains(String element) throws NullOrEmptyValueException {
        operations.append("Checked if contains: ").append(element).append("\n");
        checkNullOrEmpty(element);

        for (int i = 0; i < sizeOfArray; i++) {
            if (arrayOfElements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(List<String> foreignList) throws ArrayIndexOutOfBoundsException, NullOrEmptyValueException {
        operations.append("Checked if contains foreign list").append("\n");

        for (int i=0; i< foreignList.size(); i++) {
            if (!contains(foreignList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        operations.append("Retrieved size: ").append(sizeOfArray).append("\n");
        return sizeOfArray;
    }

    public StringBuilder getOperations() {
        return operations;
    }
}
