package com.nagarro.rl.week6.p3.plant.initial.factory;

import com.nagarro.rl.week6.p3.plant.initial.domain.Employee;
import com.nagarro.rl.week6.p3.plant.initial.domain.EngineComponent;
import com.nagarro.rl.week6.p3.plant.initial.exception.UnauthorizedEmployeeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InitialEngineFactoryTest {

    private EngineFactory engineFactory;
    @Mock
    private Employee employeeMock;
    @Mock
    private EngineComponent engineComponentMock;

    @BeforeEach
    public void setup() {
        employeeMock = mock(Employee.class);
        engineComponentMock = mock(EngineComponent.class);
        List<Employee> employees = Arrays.asList(employeeMock);
        List<EngineComponent> engineComponents = Arrays.asList(engineComponentMock, engineComponentMock, engineComponentMock);
        engineFactory = new EngineFactory(employees, engineComponents);
    }

    @Test
    public void testManufactureEnginesUnauthorizedEmployee() {
        Employee unauthorizedEmployeeMock = mock(Employee.class);

        assertThrows(UnauthorizedEmployeeException.class, () -> {
            engineFactory.manufactureEngines(1, unauthorizedEmployeeMock);
        });
    }

    @Test
    public void testManufactureEnginesUnqualifiedEmployee() {
        Employee unqualifiedEmployeeMock = mock(Employee.class);
        when(unqualifiedEmployeeMock.isAssemblyLineWorker()).thenReturn(false);

        assertThrows(UnauthorizedEmployeeException.class, () -> {
            engineFactory.manufactureEngines(1, unqualifiedEmployeeMock);
        });
    }

    @Test
    public void testGetComponentsPerEngine() {
        assertEquals(3, EngineFactory.getComponentsPerEngine());
    }
}