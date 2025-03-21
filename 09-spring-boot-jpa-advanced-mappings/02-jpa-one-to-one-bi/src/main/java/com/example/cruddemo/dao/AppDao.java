package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int theId);
    String deleteById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}
