package com.example.cruddemo.dao;

import com.example.cruddemo.model.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Long theId);
}

