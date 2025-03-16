package com.farhad.springboot.cruddemo.dao;

import com.farhad.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // define field for entity manager
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(Long theId) {
        // get and return the employee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save or update the employee (if id == 0 then saved or insert else update)
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(Long theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
