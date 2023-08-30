package com.nagarro.rl.week17.p1.main;

import com.nagarro.rl.week17.p1.model.Client;
import com.nagarro.rl.week17.p1.model.Operation;
import com.nagarro.rl.week17.p1.model.OperationType;
import com.nagarro.rl.week17.p1.service.FinancialService;

import java.util.List;

public class Action {
    private FinancialService financialService;

    public Action(FinancialService financialService) {
        this.financialService = financialService;
    }

    public void insertClients() {
        Client client1 = new Client(1, "Radu Vlad", 500000.0);
        financialService.insertClient(client1);

        Client client2 = new Client(2, "John Doe", 100000.0);
        financialService.insertClient(client2);
    }

    public void listAllClients() {
        List<Client> clients = financialService.getAllClients();
        System.out.println("All Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void getClientBalance(String name) {
        double balance = financialService.getClientBalance(name);
        System.out.println("Balance for client " + name + ": " + balance);
    }

    public void listHighBalanceClients(double threshold) {
        List<Client> highBalanceClients = financialService.getClientsWithHighBalance(threshold);
        System.out.println("Clients with a balance over " + threshold + ":");
        for (Client client : highBalanceClients) {
            System.out.println(client);
        }
    }

    public void recordOperationAndUpdateBalance(String username, OperationType operationType, double amount) {
        Operation operation = new Operation(1, operationType, amount);
        financialService.recordOperationAndUpdateBalance(operation, username);
    }

    public void printClientBalance(String name) {
        double balance = financialService.getClientBalance(name);
        System.out.println("Client balance after operation: " + balance);
    }
}
