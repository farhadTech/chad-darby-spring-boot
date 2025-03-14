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
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating new student");
		Student tempStudent = new Student("Paul", "Doe", "Paul@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		System.out.println("Student saved. Generated Id: " + tempStudent.getId());
	}
}

