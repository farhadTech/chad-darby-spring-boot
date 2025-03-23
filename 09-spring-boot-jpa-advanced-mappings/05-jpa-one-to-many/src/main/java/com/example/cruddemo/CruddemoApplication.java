package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {

		return runner -> {
//			createCourseAndStudents(appDao);
//			findCourseAndStudents(appDao);
			findStudentAndCourses(appDao);
		};
	}

	private void findStudentAndCourses(AppDao appDao) {
		int theId = 2;
		Student theStudent = appDao.findStudentAndCoursesById(theId);

		System.out.println("Loaded course " + theStudent);
		System.out.println("Associated course " + theStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDao appDao) {
		int theId = 10;
		Course theCourse = appDao.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course " + theCourse);
		System.out.println("Associated students " + theCourse.getStudents());
		System.out.println("Done!!!");
	}

	private void createCourseAndStudents(AppDao appDao) {
		// create a course
		Course tempCourse = new Course("Pacman - How to Score One Million Points?");

		// create the students
		Student tempStudent1 = new Student("Abraham", "Lincoln", "abrahamlincoln@gmail.com");
		Student tempStudent2 = new Student("John", "Kennedy", "johnkennedy@gmail.com");
		Student tempStudent3 = new Student("Soumya", "Sarkar", "soumyasarkar@gmail.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		// save the course and associated students
		System.out.println("Saving the course " + tempCourse);
		System.out.println("Associated students " + tempCourse.getStudents());

		appDao.saveCourse(tempCourse);
		System.out.println("Saved the course " + tempCourse);
	}

	private void deleteCourseAndReviews(AppDao appDao) {
		System.out.println("Deleting Course and Reviews");
		// get the id
		int theId = 10;
		appDao.deleteCourseAndReviewsByCourseId(theId);

		System.out.println("Deleted Course and Reviews");
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDao.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {
		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points.");
		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course ... Job well done!"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving course " + tempCourse);
		System.out.println("Saving reviews " + tempCourse.getReviews());

		appDao.saveCourse(tempCourse);

		System.out.println("Done saving course " + tempCourse);
	}

	private void deleteCourse(AppDao appDao) {
		int theId = 10;
		System.out.println("Deleting course " + theId);
		appDao.deleteCourseById(theId);
		System.out.println("Deleted course " + theId);
	}

	private void updateCourse(AppDao appDao) {
		int theId = 10;
		// find the course
		System.out.println("Finding Course id: " + theId);
		Course tempCourse = appDao.findCourseById(theId);
		// update the course
		System.out.println("Updating Course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things.");
		appDao.updateCourse(tempCourse);
	}

	private void updateInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Found instructor with id: " + theId);

		Instructor theInstructor = appDao.findById(theId);

		System.out.println("Updating instructor with id: " + theId);
		theInstructor.setFirstName("James");
		theInstructor.setLastName("Faulkner");
		appDao.update(theInstructor);
		System.out.println("Updating instructor with id: " + theId);
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("The associated Courses Detail: " + tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int theId = 1;
		// find the instructor
		Instructor tempInstructor = appDao.findById(theId);
		System.out.println("Instructor: " + tempInstructor);

		// find courses for instructor
		List<Course> courses = appDao.findCoursesByInstructorId(theId);

		// associate the object
		tempInstructor.setCourses(courses);
		System.out.println("The associated courses: " + courses);
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

	private void deleteInstructorById(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor with id " + theId);
 
		appDao.deleteInstructorById(theId);
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
