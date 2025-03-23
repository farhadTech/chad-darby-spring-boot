package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int theId);
    String deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    String deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor theInstructor);

    void updateCourse(Course course);
    Course findCourseById(int theId);
    String deleteCourseById(int theId);

    void saveCourse(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);
    void deleteCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);
}

