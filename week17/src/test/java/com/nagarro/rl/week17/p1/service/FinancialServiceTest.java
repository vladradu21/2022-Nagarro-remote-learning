package com.nagarro.rl.week17.p1.service;

import com.nagarro.rl.week17.p1.DAO.ClientDAO;
import com.nagarro.rl.week17.p1.DAO.OperationDAO;
import com.nagarro.rl.week17.p1.model.Client;
import com.nagarro.rl.week17.p1.model.Operation;
import com.nagarro.rl.week17.p1.model.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FinancialServiceTest {

    @Mock
    private ClientDAO clientDAO;

    @Mock
    private OperationDAO operationDAO;

    private FinancialService financialService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        financialService = new FinancialService(clientDAO, operationDAO);
    }

    @Test
    public void testGetAllClients() {
        // Mock the behavior of the clientDAO.getAllClients() method
        List<Client> mockClients = new ArrayList<>();
        mockClients.add(new Client(1, "Alice", 1000.0));
        mockClients.add(new Client(2, "Bob", 2000.0));
        when(clientDAO.getAllClients()).thenReturn(mockClients);

        // Call the method to be tested
        List<Client> result = financialService.getAllClients();

        // Verify the result
        assertEquals(mockClients, result);

        // Verify that the clientDAO.getAllClients() method was called
        verify(clientDAO).getAllClients();
    }

    @Test
    public void testGetClientBalance() {
        // Mock the behavior of the clientDAO.getClientBalance() method
        String name = "Alice";
        double mockBalance = 1500.0;
        when(clientDAO.getClientBalance(name)).thenReturn(mockBalance);

        // Call the method to be tested
        double result = financialService.getClientBalance(name);

        // Verify the result
        assertEquals(mockBalance, result);

        // Verify that the clientDAO.getClientBalance() method was called with the correct parameter
        verify(clientDAO).getClientBalance(name);
    }

    @Test
    public void testGetClientsWithHighBalance() {
        // Mock the behavior of the clientDAO.getClientsWithHighBalance() method
        double threshold = 1000.0;
        List<Client> mockClients = new ArrayList<>();
        mockClients.add(new Client(1, "Alice", 1500.0));
        when(clientDAO.getClientsWithHighBalance(threshold)).thenReturn(mockClients);

        // Call the method to be tested
        List<Client> result = financialService.getClientsWithHighBalance(threshold);

        // Verify the result
        assertEquals(mockClients, result);

        // Verify that the clientDAO.getClientsWithHighBalance() method was called with the correct parameter
        verify(clientDAO).getClientsWithHighBalance(threshold);
    }

    @Test
    public void testRecordOperationAndUpdateBalance() {
        // Create test data
        String name = "Alice";
        OperationType operationType = OperationType.PAY;
        double amount = 500.0;
        Operation operation = new Operation(1, operationType, amount);

        // Set the initial balance for Alice
        double initialBalance = 100000.0;
        when(clientDAO.getClientBalance(name)).thenReturn(initialBalance);

        // Call the method to be tested
        financialService.recordOperationAndUpdateBalance(operation, name);

        // Verify that the operationDAO.recordOperationAndUpdateBalance() method was called with the correct operation and name
        verify(operationDAO).recordOperationAndUpdateBalance(operation, name);
    }
}