package com.eklakshya.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.eklakshya.model.Student;

public class StudentDAO extends GenericDAO<Student>{

	public StudentDAO() {
		super(Student.class);
	}
	
	@Transactional
	public Student getStudentDetails(Integer studentId) {
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student)session.get(Student.class, studentId);
		tx.commit();
		session.close();
		return student;
	}

}
