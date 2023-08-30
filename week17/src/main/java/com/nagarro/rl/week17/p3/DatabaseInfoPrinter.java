package com.nagarro.rl.week17.p3;

import java.sql.*;

public class DatabaseInfoPrinter {
    private String url;
    private String username;
    private String password;

    public DatabaseInfoPrinter(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void printDatabaseInfo(String schema) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            printTablesAndColumns(metaData, schema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printTablesAndColumns(DatabaseMetaData metaData, String schema) throws SQLException {
        ResultSet tables = metaData.getTables(null, schema, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.println("Table: " + tableName);

            printColumns(metaData, schema, tableName);
        }
        tables.close();
    }

    private void printColumns(DatabaseMetaData metaData, String schema, String tableName) throws SQLException {
        ResultSet columns = metaData.getColumns(null, schema, tableName, null);
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            System.out.println("Column: " + columnName);
        }
        columns.close();
    }
}
