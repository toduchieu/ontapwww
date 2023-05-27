package edu.iuh.ktpm.controllers;

import edu.iuh.ktpm.entities.Employee;
import edu.iuh.ktpm.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/home")
    public ModelAndView employeeHome(){
        ModelAndView view = new ModelAndView();

        //Test save employee
        Employee employee = new Employee();
        employee.setId("emp001");
        employee.setEmail("levan@gmail.com");
        employee.setGender("nam");
        employee.setFirstName("Lê");
        employee.setLastName("Văn");
        String phone1 = "012345678";
        String phone2 = "0987654321";
        Set<String> phone = new HashSet<>();
        phone.add(phone1);
        phone.add(phone2);
        employee.setPhones(phone);
        employeeService.save(employee);

        view.setViewName("redirect:/project/home");
        return view;
    }
}
