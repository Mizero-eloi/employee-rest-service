package com.example.employeerestservice.service;

import com.example.employeerestservice.exception_handler.EmployeeNotFound;
import com.example.employeerestservice.model.Employee;
import com.example.employeerestservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public EntityModel<Employee> getEmployeeById(@PathVariable int empId){
        Employee employee = service.getEmployeeById(empId);
        if (employee == null)
            throw new EmployeeNotFound("Employee Not Found");
        EntityModel<Employee> model = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("all-employees");

        model.add(link);

        return model;
    }

    @PostMapping("/employees/user")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee emp){
        Employee newEmployeee = service.saveEmployee(emp);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId}")
                .buildAndExpand(newEmployeee.getEmployeeId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/employees/delete/{empId}")
    public Employee deleteEmployee(@PathVariable int empId){
        Employee emp = service.deleteEmployee(empId);
        return emp;
    }

}
