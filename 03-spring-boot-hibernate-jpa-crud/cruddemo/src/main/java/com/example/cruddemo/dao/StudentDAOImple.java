package com.example.cruddemo.dao;

import com.example.cruddemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImple implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImple(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    //  implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        return theQuery.getResultList();
    }

    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName = :lastName", Student.class);
        // set query parameters
        theQuery.setParameter("lastName", theLastName);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(theStudent);
    }
}
