package com.example.employeerestservice.service;

import com.example.employeerestservice.exception_handler.EmployeeNotFound;
import com.example.employeerestservice.model.Employee;
import com.example.employeerestservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao service;


    @GetMapping("/employees")
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
        Employee employee = service.getEmployeeById(empId);
        if (employee == null)
            throw new EmployeeNotFound("Employee Not Found");
        return employee;
    }

    @PostMapping("/employees/user")
    public void saveEmployee(@RequestBody Employee emp){
        service.saveEmployee(emp);
    }

}
