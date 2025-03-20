package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int theId);
}
