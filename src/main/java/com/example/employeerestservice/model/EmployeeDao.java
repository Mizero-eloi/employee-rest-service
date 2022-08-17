//package com.example.employeerestservice.model;
//
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Component
//public class EmployeeDao {
//    static List<Employee> list = new ArrayList<>();
//
//    static {
//        list.add(new Employee(1234, "Nancy", "nancy@gmail.com"));
//        list.add(new Employee(1235, "Daniel", "daniel@gmail.com"));
//        list.add(new Employee(1236, "Scott", "scott@gmail.com"));
//    }
//
//    public List<Employee> getAllEmployees() {
//        return list;
//    }
//
//    public Employee getEmployeeById(int empId) {
//        return  list.stream().filter(emp -> emp.getEmployeeId() == empId).findAny().orElse(null);
//
//    }
//
//    public Employee saveEmployee(Employee emp) {
//        emp.setEmployeeId(list.size() + 1);
//        list.add(emp);
//
//        return emp;
//    }
//
//    public Employee deleteEmployee(int empId) {
//        Iterator<Employee> iterator = list.iterator();
//
//        while(iterator.hasNext()){
//            Employee emp = iterator.next();
//            if(empId == emp.getEmployeeId()){
//                iterator.remove();
//                return emp;
//            }
//        }
//        return  null;
//    }
//}
