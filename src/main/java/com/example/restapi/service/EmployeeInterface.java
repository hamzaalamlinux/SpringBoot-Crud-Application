package com.example.restapi.service;

import com.example.restapi.model.Employee;

import java.util.List;

public interface EmployeeInterface {
    Employee saveEmployee(Employee employee);

     List<Employee> getAllEmployees();

     Employee getEmployeeById(long id);

     Employee UpdateEmployee(Employee employee , long id);

     void DeleteEmployee(long id);

}
