package com.nagarro.rl.week17.p1.DAO;

import com.nagarro.rl.week17.p1.model.Operation;
import com.nagarro.rl.week17.p1.model.OperationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationDAO {
    private Connection connection;

    public OperationDAO(Connection connection) {
        this.connection = connection;
    }

    public void recordOperationAndUpdateBalance(Operation operation, String name) {
        try {
            // Record the operation
            String operationQuery = "INSERT INTO operation (id, type, amount) VALUES (?, ?, ?)";
            try (PreparedStatement operationStatement = connection.prepareStatement(operationQuery)) {
                operationStatement.setInt(1, operation.getId());
                operationStatement.setString(2, operation.getType().name());
                operationStatement.setDouble(3, operation.getAmount());
                operationStatement.executeUpdate();
            }

            // Update the client's balance
            String balanceQuery = "UPDATE client SET balance = balance ";
            if (operation.getType() == OperationType.PAY) {
                balanceQuery += "- ?";
            } else if (operation.getType() == OperationType.RECEIVE) {
                balanceQuery += "+ ?";
            }
            balanceQuery += " WHERE name = ?";
            try (PreparedStatement balanceStatement = connection.prepareStatement(balanceQuery)) {
                balanceStatement.setDouble(1, operation.getAmount());
                balanceStatement.setString(2, name);
                balanceStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
