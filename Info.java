package com.lti.main;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import com.lti.model.Course;
import com.lti.model.DegreeCourse;
import com.lti.model.DiplomaCourse;
import com.lti.model.Student;

public class Info {

	public static void display(Student student) { // call by reference
		// System.out.println(student.getId()+" "+student.getName()+"
		// "+student.getDateOfBirth()+" "+student.getCollegeName());
		System.out.println(student.getId() + " " + student.getName() + " " + student.getDateOfBirth() + " "
				+ Student.getCollegeName() + " " + Arrays.toString(student.getPhoneNumbers()));

	}

	public static void display(Student[] students) {
		/*
		 * for(int i=0;i<students.length;i++) { display(student[i]); }
		 */
		// enhanced for/ extended for

		for (Student st : students) {
			display(st);
		}
	}

	public static void display(List<Student> students) {
//		for(Student st:students) {
//			display(st);
//		}

		// Iterator<Student> studs = students.iterator();
		ListIterator<Student> studs = students.listIterator();
		while (studs.hasNext()) {
			Student st = studs.next();
			display(st);
		}

		System.out.println("-----------------------------------------------");

		while (studs.hasPrevious()) {
			Student st1 = studs.previous();
			display(st1);
		}

	}

	/*
	 * public static void displayCourse(Course course) {
	 * //System.out.println(course.getId() + " " + course.getName() + " " +
	 * course.getDuration() + " " + course.getFees()); }
	 */

	/*
	 * public static void displayCourse(Course[] courses) { for (Course c : courses)
	 * { displayCourse(c); } }
	 */

	/*
	 * public static void displayCourse(List<Course> courses) { ListIterator<Course>
	 * iterator = courses.listIterator(); while (iterator.hasNext()) { Course c =
	 * iterator.next(); displayCourse(c); }
	 * System.out.println("-----------------------"); while (iterator.hasPrevious())
	 * { Course c = iterator.previous(); displayCourse(c); } }
	 */

	public static void displayCourse(Course course) {
		course.calculateMonthlyFee();
	}
	
}
