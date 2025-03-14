package com.example.cruddemo.dao;

import com.example.cruddemo.model.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAOImple implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImple(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    //  implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
