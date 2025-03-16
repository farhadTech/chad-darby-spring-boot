package com.farhad.springboot.cruddemo.service;

import com.farhad.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long theId);
    Employee save(Employee theEmployee);
    void deleteById(Long theId);
}
