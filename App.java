package com.lti.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.model.Course;
import com.lti.model.DegreeCourse;
import com.lti.model.DegreeLevel;
import com.lti.model.DiplomaCourse;
import com.lti.model.Student;
import com.lti.model.Type;

public class App {

	public static void main(String[] args) {
		// scenario2();
		// scenario3();
		//scenario4();
		//scenario8();
		scenario9();
	}

	public static void scenario1() {
		Student student = new Student();
		String[] student2phoneNumbers = { "9848484", "78747473" };
		String[] student3phoneNumbers = { "8877655", "46464646" };
		Student student2 = new Student(101, "John", LocalDate.now(), student2phoneNumbers);
		Student student3 = new Student(102, "Mark", LocalDate.of(2003, 12, 31), student3phoneNumbers);

		Info info = new Info();
		info.display(student2);
		info.display(student3);
	}

	public static void scenario2() {
		// int[] num=new int[10];
		Student[] students = new Student[3];
		String[] student1phoneNumbers = { "8877655", "46464646" };
		String[] student2phoneNumbers = { "9848484", "78747473" };
		String[] student3phoneNumbers = { "7765566", "78765776" };

		students[0] = new Student(101, "John", LocalDate.now(), student1phoneNumbers);
		students[1] = new Student(102, "Mark", LocalDate.now(), student2phoneNumbers);
		students[2] = new Student(103, "Bob", LocalDate.now(), student3phoneNumbers);

		Info info = new Info();
		info.display(students);

	}

	public static void scenario3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of students:");
		int noOfStudents = sc.nextInt();

		Student[] students = new Student[noOfStudents];
		// noOfStudents=400;
		for (int i = 0; i < students.length; i++) {
			System.out.println("Enter your id,name,date of birth(dd/MM/yyyy)");
			int id = sc.nextInt();
			String name = sc.next();
			String date = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dateOfBirth = LocalDate.parse(date, formatter);

			students[i] = new Student(id, name, dateOfBirth);
		}

		Info.display(students);
	}

	public static void scenario4() {
		List<Student> students = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter your id,name,date of birth(dd/MM/yyyy)");
			int id = sc.nextInt();
			String name = sc.next();
			String date = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dateOfBirth = LocalDate.parse(date, formatter);

			// storing student object in collection.
			students.add(new Student(id, name, dateOfBirth));

			System.out.println("Press 0 to stop?");
			int num = sc.nextInt();
			if (num == 0)
				break;
		} while (true);

		Info.display(students);
	}

	/*
	 * public static void scenario5() { Course c1 = new Course(1001, "Java", 2,
	 * 2000.00); Course c2 = new Course(1002, "Oracle", 2, 2200.00); Course c3 = new
	 * Course(1003, "React", 2, 3000.00);
	 * 
	 * Info.displayCourse(c1); Info.displayCourse(c2); Info.displayCourse(c3); }
	 */

	/*
	 * public static void scenario6() { Course[] courses = new Course[3];
	 * 
	 * courses[0] = new Course(1001, "Java", 2, 2000.00); courses[1] = new
	 * Course(1002, "Oracle", 2, 2200.00); courses[2] = new Course(1003, "React", 2,
	 * 3000.00);
	 * 
	 * Info.displayCourse(courses); }
	 */

	/*
	 * public static void scenario7() { Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("Enter no of courses"); int noOfCourses = sc.nextInt();
	 * 
	 * Course[] courses = new Course[noOfCourses];
	 * 
	 * for (int i = 0; i < courses.length; i++) {
	 * System.out.println("Enter course id, name, duration and fees"); int id =
	 * sc.nextInt(); sc.nextLine(); String name = sc.nextLine(); int duration =
	 * sc.nextInt(); double fees = sc.nextDouble();
	 * 
	 * courses[i] = new Course(id, name, duration, fees); }
	 * Info.displayCourse(courses);
	 * 
	 * }
	 */

	/*
	 * public static void scenario8() { Scanner sc = new Scanner(System.in);
	 * 
	 * List<Course> courses = new ArrayList<>();
	 * 
	 * do { System.out.println("Enter course id, name, duration and fees"); int id =
	 * sc.nextInt(); sc.nextLine(); String name = sc.nextLine(); int duration =
	 * sc.nextInt(); double fees = sc.nextDouble();
	 * 
	 * courses.add(new Course(id, name, duration, fees));
	 * 
	 * System.out.println("Press 0 to stop"); int num = sc.nextInt(); if (num == 0)
	 * { break; } } while (true);
	 * 
	 * Info.displayCourse(courses);
	 * 
	 * }
	 */
	public static void scenario9() {
		DegreeCourse degreeCourse=new DegreeCourse(101, "Btech", 96, 100000, DegreeLevel.Bachelors,true);
		Info.displayCourse(degreeCourse);
		
		DiplomaCourse diplomaCourse=new DiplomaCourse(102, "Agri", 24, 50000, Type.Academic);
		Info.displayCourse(diplomaCourse);
	}
}
