package edu.iuh.ktpm.services.impl;

import edu.iuh.ktpm.entities.Employee;
import edu.iuh.ktpm.repositories.EmployeeRepository;
import edu.iuh.ktpm.services.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
