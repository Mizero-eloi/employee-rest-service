package com.example.employeerestservice.service;

import com.example.employeerestservice.model.Employee;
import com.example.employeerestservice.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRepoController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/jpa/employee")
    public List<Employee> getAll(){
        return repo.findAll();
    }
}
