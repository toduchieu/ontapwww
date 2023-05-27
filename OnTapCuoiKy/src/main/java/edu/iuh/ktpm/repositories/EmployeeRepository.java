package edu.iuh.ktpm.repositories;

import edu.iuh.ktpm.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
