package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDao{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class, theId);
        return instructor;
    }

    @Override
    @Transactional
    public String deleteById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(instructor);
        return "Entity manager has been deleted";
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public String deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        entityManager.remove(instructorDetail);
        return "Entity manager has been deleted";
    }
}




