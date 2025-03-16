package com.farhad.springboot.cruddemo.rest;

import com.farhad.springboot.cruddemo.entity.Employee;
import com.farhad.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Long employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return theEmployee;
    }
    // add mapping for POST /employees - save new employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    // add mapping for PUT /employees - update existing employees
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        // throw new exception if null
        if(tempEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee deleted - " + employeeId;
    }
}
