package com.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.demo.entity.Student;

public class StudentDAOImpl implements StudentDao {
//	An EntityManager instance is associated with a persistence context.
	private EntityManager entityManager;

	public StudentDAOImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Student getStudentById(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);

	}

	@Override
	public void removeStudent(Student student) {
		entityManager.remove(student);
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}

	@Override
	public void beginTransaction() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

	}

}
