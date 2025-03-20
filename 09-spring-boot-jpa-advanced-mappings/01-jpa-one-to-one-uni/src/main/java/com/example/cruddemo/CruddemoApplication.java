package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			createInstructor(appDao);
		};
	}

	private void createInstructor(AppDao appDao) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube", "luv 2 code");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor

		//
		// Note: This will also save the details object
 		// because of CascadeType.ALL
		//
		System.out.println("Saving Instructor: " + tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done Saving Instructor: " + tempInstructor);
	}
}
