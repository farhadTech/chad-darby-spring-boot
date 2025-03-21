package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int theId);
    String deleteById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    String deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);

    public void update(Instructor theInstructor);
}

