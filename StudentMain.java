package com.lti.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.lti.dao.InMemoryStudentDaoImpl;
import com.lti.dao.PersistentStudentDaoImpl;
import com.lti.dao.StudentDao;
import com.lti.model.Course;
import com.lti.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		//StudentDao studentDao = new InMemoryStudentDaoImpl();
		StudentDao studentDao = new PersistentStudentDaoImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println(
					"1.Add a student.\n2.Update a Student\n3.Remove a Student\n4.Search a Student\n5.View All Students."
					+ "\n6.Enroll\n7.View All Enrollments");
			int ch = sc.nextInt();
			int id;
			String name;
			String date;
			DateTimeFormatter formatter;
			LocalDate dateOfBirth;
			Student student;
			switch (ch) {

			case 1:
				//System.out.println("Enter your id,name,date of birth(dd/MM/yyyy)");
				//id = sc.nextInt();
				System.out.println("Enter your name,date of birth(dd/MM/yyyy)");
				name = sc.next();
				date = sc.next();
				formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dateOfBirth = LocalDate.parse(date, formatter);

				//student = new Student(id, name, dateOfBirth);
				student = new Student();
				student.setName(name);
				student.setDateOfBirth(dateOfBirth);
				
				boolean result = studentDao.addStudent(student);
				if (result) {
					System.out.println("Congratulations!!You registration is confirmed.");
				} else {
					System.out.println("Sorry!!!Registration failed.");
				}
				break;
			case 2:
				System.out.println("Enter your id,name,date of birth(dd/MM/yyyy)");
				id = sc.nextInt();
				name = sc.next();
				date = sc.next();
				formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dateOfBirth = LocalDate.parse(date, formatter);

				student = new Student(id, name, dateOfBirth);
				studentDao.updateStudent(student);
				break;
			case 3:
				System.out.println("Enter student id:");
				id = sc.nextInt();
				studentDao.removeStudent(id);
				break;
			case 4:
				System.out.println("Enter student id:");
				id = sc.nextInt();
				student = studentDao.findAStudent(id);
				if (student != null)
					System.out.println(student.getId() + " " + student.getName() + " " + student.getDateOfBirth());
				else {
					System.out.println("Student not found.");
				}
				break;
			case 5:
				List<Student> students = studentDao.viewAllStudents();
				if (students.isEmpty()) {
					System.out.println("No student found.");
				} else {
					for (Student st : students) {
						System.out.println(st.getId() + " " + st.getName() + " " + st.getDateOfBirth());
					}
				}
				break;
			case 6:
				System.out.println("Enter student id and course id:");
				int studentId=sc.nextInt();
				int courseId=sc.nextInt();
				studentDao.enroll(studentId, courseId);
				break;
			case 7:
				Set<Entry<Student, Course>> enrollments=studentDao.viewEnrollments();
				Iterator<Entry<Student, Course>> allEnrollments=enrollments.iterator();
				while(allEnrollments.hasNext()) {
					Entry<Student, Course> enrollment=allEnrollments.next();
					Student st= enrollment.getKey();
					Course cs=enrollment.getValue();
					System.out.println(st.getId()+" "+st.getName()+" "+st.getDateOfBirth()+" "+cs.getId()+cs.getName());
				}
				break;		
			default:
				flag = false;
				break;
			}

		} while (flag);

	}

}
