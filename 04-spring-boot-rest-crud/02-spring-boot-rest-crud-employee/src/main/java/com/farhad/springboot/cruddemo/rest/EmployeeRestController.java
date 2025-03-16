package com.farhad.springboot.cruddemo.rest;

import com.farhad.springboot.cruddemo.dao.EmployeeDAO;
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

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id JSON ... set id to 0.
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0L);
        return employeeService.save(theEmployee);
    }
}
