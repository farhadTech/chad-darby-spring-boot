package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a new student object..");
		Student tempStudent = new Student("Jacob", "watson", "jacob@gmail.com");

		System.out.println("Saving the student object..");
		studentDAO.save(tempStudent);

		System.out.println("Retrieving the student object by last name..");
		List<Student> theStudent = studentDAO.findByLastName("doe");

		// display student(s)
		for(Student student : theStudent) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student's ID: " + tempStudent.getId());

		// retrieve student based on the id
		System.out.println("\nRetrieving student object... with id: " + tempStudent.getId());

		// display student
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Retrieved student object: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple students");
		Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
		Student tempStudent2 = new Student("Jane", "Austen", "janedoe@gmail.com");
		Student tempStudent3 = new Student("Jack", "Smith", "jackdoe@gmail.com");

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating the new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("Saving the new student object...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Successfully created the new student object. generated id:" + tempStudent.getId());

		//
	}
}




