package com.example.cruddemo.dao;

import com.example.cruddemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public interface StudentDAO {
    void save(Student theStudent);
}