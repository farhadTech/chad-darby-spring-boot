package com.farhad.springboot.cruddemo.dao;

import com.farhad.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(Long theId);
    Employee save(Employee theEmployee);
    void deleteById(Long theId);
}
