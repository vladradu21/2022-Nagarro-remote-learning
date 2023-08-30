package com.nagarro.rl.week17.p1.main;

import com.nagarro.rl.week17.p1.DAO.ClientDAO;
import com.nagarro.rl.week17.p1.DAO.OperationDAO;
import com.nagarro.rl.week17.p1.model.OperationType;
import com.nagarro.rl.week17.p1.service.FinancialService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/week17";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            ClientDAO clientDAO = new ClientDAO(connection);
            OperationDAO operationDAO = new OperationDAO(connection);

            FinancialService financialService = new FinancialService(clientDAO, operationDAO);
            Action action = new Action(financialService);

            action.insertClients();
            action.listAllClients();
            action.getClientBalance("Radu Vlad");
            action.listHighBalanceClients(100000);
            action.recordOperationAndUpdateBalance("Radu Vlad", OperationType.PAY, 5000.0);
            action.printClientBalance("Radu Vlad");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
