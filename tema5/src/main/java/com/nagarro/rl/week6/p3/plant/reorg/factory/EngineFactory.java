package com.nagarro.rl.week6.p3.plant.reorg.factory;

import com.nagarro.rl.week6.p3.plant.reorg.domain.Employee;
import com.nagarro.rl.week6.p3.plant.reorg.domain.Engine;
import com.nagarro.rl.week6.p3.plant.reorg.domain.EngineArchitecture;
import com.nagarro.rl.week6.p3.plant.reorg.exception.UnqualifiedEmployeeException;
import com.nagarro.rl.week6.p3.plant.reorg.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory {

    private EmployeeService employeeService;

    public EngineFactory(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Engine> manufactureEngines(int numberOfEngines, Employee assignedEmployee) {
        if (!employeeService.isAssemblyLineWorker(assignedEmployee)) {
            throw new UnqualifiedEmployeeException("Employee [" + assignedEmployee.getName() + "] is not qualified to build engines!");
        }

        List<Engine> newEngines = new ArrayList<Engine>();
        for (int i = 0; i < numberOfEngines; i++) {
            newEngines.add(new Engine(EngineArchitecture.L4, 2.0, 210));
        }
        return newEngines;
    }

}
