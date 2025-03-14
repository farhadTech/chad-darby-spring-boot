package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			readStudent(studentDAO);
		};
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
		Student tempStudent2 = new Student("Jane", "Doe", "janedoe@gmail.com");
		Student tempStudent3 = new Student("Jack", "Doe", "jackdoe@gmail.com");

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




