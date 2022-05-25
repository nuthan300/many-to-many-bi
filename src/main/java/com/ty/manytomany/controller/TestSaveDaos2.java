package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dao.Course;
import com.ty.manytomany.dao.Student;

public class TestSaveDaos2 {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("Balaji");
		student1.setAge(25);

		Course course1 = new Course();
		course1.setDuration(3);
		course1.setName("Java");

		Course course2 = new Course();
		course2.setDuration(3);
		course2.setName("Python");

		Course course3 = new Course();
		course3.setDuration(3);
		course3.setName("HTML");

		List<Student> studentList1 = new ArrayList<Student>();
		studentList1.add(student1);
		course1.setStudents(studentList1);

		List<Student> studentList2 = new ArrayList<Student>();
		studentList2.add(student1);
		course2.setStudents(studentList2);

		List<Student> studentList3 = new ArrayList<Student>();
		studentList3.add(student1);
		course3.setStudents(studentList3);

//		List<Course> courseList1 = new ArrayList<Course>();
//		courseList1.add(course1);
//		courseList1.add(course2);
//		courseList1.add(course3);
//		student1.setCourses(courseList1);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(course3);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();

	}
}
