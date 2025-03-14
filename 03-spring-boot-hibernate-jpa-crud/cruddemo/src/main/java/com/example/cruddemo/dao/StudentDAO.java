package com.example.cruddemo.dao;

import com.example.cruddemo.model.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Long theId);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
}

