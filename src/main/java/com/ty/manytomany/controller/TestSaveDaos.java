package com.ty.manytomany.controller;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dao.Course;
import com.ty.manytomany.dao.Student;

public class TestSaveDaos {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("chetan");
		student1.setAge(24);

		Course course1 = entityManager.find(Course.class, 1);
		Course course2 = entityManager.find(Course.class, 2);
		Course course3 = entityManager.find(Course.class, 3);

		List<Student> studentList1 = course1.getStudents();
		studentList1.add(student1);

		List<Student> studentList2 = course2.getStudents();
		studentList2.add(student1);

		List<Student> studentList3 = course3.getStudents();
		studentList3.add(student1);

//		List<Course> courseList1 = new ArrayList<Course>();
//		courseList1.add(course1);
//		courseList1.add(course2);
//		courseList1.add(course3);

//		student1.setCourses(courseList1);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.merge(course1);
		entityManager.merge(course2);
		entityManager.merge(course3);
		entityTransaction.commit();

	}
}
