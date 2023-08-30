package com.nagarro.rl.week5.p2;

public class Main {

    public static void main(String[] args) {
        simulate();
    }

    public static void simulate() {
        List myList = new StringList(new String[10], 0, new StringBuilder());

        try {
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("");
        } catch (NullOrEmptyValueException e) {
            System.out.println(e.getMessage());
        } catch (NonNumericValueException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(myList.get(0));
            System.out.println(myList.get(1));
            System.out.println(myList.get(2));
            System.out.println(myList.contains("2"));
            System.out.println(myList.contains("4"));
            System.out.println(myList.size());

        } catch (NullOrEmptyValueException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<String> foreignList = new StringList(new String[5], 0, new StringBuilder());
            foreignList.add("1");
            foreignList.add("3");
            System.out.println(myList.containsAll(foreignList));
            foreignList.add("4");
            System.out.println(myList.containsAll(foreignList));
        } catch (NullOrEmptyValueException e) {
            System.out.println(e.getMessage());
        } catch (NonNumericValueException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(((StringList) myList).getOperations());
    }
}
