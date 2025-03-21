package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Course;
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
//			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetail(appDao);
//			deleteInstructorDetail(appDao);
//			createInstructorWithCourses(appDao);
			findInstructorWithCourses(appDao);
		};
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDao.findById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		// associated courses
		System.out.println("Finding instructor with courses: " + tempInstructor.getCourses());
		System.out.println("Done finding instructor with id: " + theId);
	}

	private void createInstructorWithCourses(AppDao appDao) {
		// Create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@gmail.com");

		// create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);

		// save the instructor

		//
 		// Note: This will also save the courses because of CascadeType.PERSIST
 		//
		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("The Courses: " + tempInstructor.getCourses());
		appDao.save(tempInstructor);
		System.out.println("Saving Instructor: " + tempInstructor);
	}

	private void deleteInstructorDetail(AppDao appDao) {
		// delete the instructorDetail with the instructor
		int theId = 3;
		System.out.println("Deleting instructor detail with instructor id: " + theId);

		appDao.deleteInstructorDetailById(theId);
		System.out.println("Deleted instructor detail with instructor id: " + theId);
	}

	private void findInstructorDetail(AppDao appDao) {
		// get the instructor details
		int theId = 2;
		InstructorDetail InstructorDetails = appDao.findInstructorDetailById(theId);

		// print the instructor details
		System.out.println("Instructor detail: " + InstructorDetails);
		System.out.println("The associated instructor: " + InstructorDetails.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor with id " + theId);
 
		appDao.deleteById(theId);
		System.out.println("Deleted instructor " + theId);
	}

	private void findInstructor(AppDao appDao) {
		int theId = 2;
		System.out.println("Finding instructor with id " + theId);

		Instructor theInstructor = appDao.findById(theId);
		System.out.println("theInstructor = " + theInstructor);
		System.out.println("The associated instructorDetail only: " + theInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

//		// create the instructor
//		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
//
//		// create the instructor detail
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("http://www.luv2code.com/youtube", "luv 2 code");


		// create the instructor
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.madhupatel.com/youtube", "swimming");

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
