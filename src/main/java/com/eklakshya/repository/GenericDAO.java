package com.eklakshya.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAO<T> {
	
	protected Class<T> clazz;
	@Autowired
	private SessionFactory sessionFactory;

	public GenericDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Transactional
	public void update(T t) throws Exception {
		getSession().update(t);
	}

	@Transactional
	public void save(T t) throws Exception {
		getSession().save(t);
	}

	@Transactional
	public void persist(T t) throws Exception {
		getSession().persist(t);
	}

	@Transactional
	public void delete(T t) throws Exception {
		getSession().delete(t);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
