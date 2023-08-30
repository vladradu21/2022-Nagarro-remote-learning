package com.nagarro.rl.week17.p3;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "password";
        String schema = "week17";

        DatabaseInfoPrinter printer = new DatabaseInfoPrinter(url, username, password);
        printer.printDatabaseInfo(schema);
    }
}
