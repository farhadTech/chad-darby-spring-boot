package com.farhad.springboot.cruddemo.service;

import com.farhad.springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long theId);
    Employee save(Employee theEmployee);
    void deleteById(Long theId);
}
