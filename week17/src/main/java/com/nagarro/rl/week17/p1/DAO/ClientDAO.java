package com.nagarro.rl.week17.p1.DAO;

import com.nagarro.rl.week17.p1.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertClient(Client client) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO client (id, name, balance) VALUES (?, ?, ?)")) {
            statement.setInt(1, client.getId());
            statement.setString(2, client.getName());
            statement.setDouble(3, client.getBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM client");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");

                Client client = new Client(id, name, balance);
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public double getClientBalance(String name) {
        double balance = 0;

        try (PreparedStatement statement = connection.prepareStatement("SELECT balance FROM client WHERE name = ?")) {
            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }

    public List<Client> getClientsWithHighBalance(double threshold) {
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM client WHERE balance > ?")) {
            statement.setDouble(1, threshold);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double balance = resultSet.getDouble("balance");

                    Client client = new Client(id, name, balance);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
