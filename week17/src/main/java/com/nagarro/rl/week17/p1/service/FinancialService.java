package com.nagarro.rl.week17.p1.service;

import com.nagarro.rl.week17.p1.DAO.ClientDAO;
import com.nagarro.rl.week17.p1.DAO.OperationDAO;
import com.nagarro.rl.week17.p1.model.Client;
import com.nagarro.rl.week17.p1.model.Operation;

import java.util.List;

public class FinancialService {

    private ClientDAO clientDAO;
    private OperationDAO operationDAO;

    public FinancialService(ClientDAO clientDAO, OperationDAO operationDAO) {
        this.clientDAO = clientDAO;
        this.operationDAO = operationDAO;
    }

    public void insertClient(Client client) {
        clientDAO.insertClient(client);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    public double getClientBalance(String name) {
        return clientDAO.getClientBalance(name);
    }

    public List<Client> getClientsWithHighBalance(double threshold) {
        return clientDAO.getClientsWithHighBalance(threshold);
    }

    public void recordOperationAndUpdateBalance(Operation operation, String name) {
        operationDAO.recordOperationAndUpdateBalance(operation, name);
    }
}
