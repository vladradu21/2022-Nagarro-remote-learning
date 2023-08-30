package com.nagarro.rl.week6.p3.plant.reorg.factory;

import com.nagarro.rl.week6.p3.plant.reorg.domain.Employee;
import com.nagarro.rl.week6.p3.plant.reorg.domain.Engine;
import com.nagarro.rl.week6.p3.plant.reorg.domain.EngineArchitecture;
import com.nagarro.rl.week6.p3.plant.reorg.exception.UnqualifiedEmployeeException;
import com.nagarro.rl.week6.p3.plant.reorg.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ReorgEngineFactoryTest {

    private EngineFactory engineFactory;
    @Mock
    private EmployeeService employeeServiceMock;
    @Mock
    private Employee employeeMock;

    @BeforeEach
    public void setup() {
        employeeServiceMock = mock(EmployeeService.class);
        employeeMock = mock(Employee.class);
        engineFactory = new EngineFactory(employeeServiceMock);
    }

    @Test
    void testManufactureEnginesQualifiedEmployee() {
        when(employeeServiceMock.isAssemblyLineWorker(employeeMock)).thenReturn(true);

        List<Engine> engineList = engineFactory.manufactureEngines(3, employeeMock);
        assertEquals(3, engineList.size());

        for(Engine engine : engineList) {
            assertEquals(EngineArchitecture.L4, engine.getEngineArchitecture());
            assertEquals(2.0, engine.getDisplacement());
            assertEquals(210, engine.getHorsePower());
        }

        verify(employeeServiceMock, times(1)).isAssemblyLineWorker(employeeMock);
    }

    @Test
    public void testManufactureEnginesUnqualifiedEmployee() {
        when(employeeServiceMock.isAssemblyLineWorker(employeeMock)).thenReturn(false);

        assertThrows(UnqualifiedEmployeeException.class, () -> {
           engineFactory.manufactureEngines(3, employeeMock);
        });

        verify(employeeServiceMock, times(1)).isAssemblyLineWorker(employeeMock);
    }
}