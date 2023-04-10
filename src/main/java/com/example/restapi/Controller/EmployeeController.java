package com.example.restapi.Controller;

import com.example.restapi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restapi.service.EmployeeInterface;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeInterface employeeInterface;

    public EmployeeController(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeInterface.saveEmployee(employee) , HttpStatus.CREATED);
    }
    @GetMapping()

    public List<Employee> getAllEmployees(){
        return employeeInterface.getAllEmployees();
    }

    @GetMapping("{id}")
    public  ResponseEntity<Employee> getEmployeeId(@PathVariable("id")  long employeeId){
            return  new ResponseEntity<Employee>(employeeInterface.getEmployeeById(employeeId) , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeInterface.UpdateEmployee(employee , id) , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")  long id){

        employeeInterface.DeleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully" , HttpStatus.OK);
    }
}
