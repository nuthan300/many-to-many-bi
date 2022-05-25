package com.ty.manytomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.ty.manytomany.dao.Course;
import com.ty.manytomany.dao.Student;

public class TestGetStudentCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, 2);
		System.out.println(student);
		System.out.println(student.getCourses());
		
//		Course course =  entityManager.find(Course.class, 2);
//		System.out.println(course);
//		System.out.println(course.getStudents());
	}
}
