package com.example.restapi.ServiceImpl;

import com.example.restapi.Exception.ResourceNotFoundException;
import com.example.restapi.model.Employee;
import org.springframework.stereotype.Service;
import com.example.restapi.repository.EmployeeRepository;
import com.example.restapi.service.EmployeeInterface;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
       return  employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee" , "id" , id));

    }

    @Override
    public Employee UpdateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee" , "Id" , id));
        existingEmployee.setFirstname(employee.getFirstname());
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setEmail(employee.getEmail());
        // save existing Employee//
        employeeRepository.save(existingEmployee);
        return  existingEmployee;
    }

    @Override
    public void DeleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee" , "Id" , id));

        employeeRepository.deleteById(id);

    }
}
