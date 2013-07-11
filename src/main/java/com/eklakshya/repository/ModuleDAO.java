package com.eklakshya.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.eklakshya.model.Module;
import com.eklakshya.model.Student;

public class ModuleDAO extends GenericDAO<Module>{

	public ModuleDAO() {
		super(Module.class);
	}

	public Module getStudentDetails(Integer moduleId) {
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Module module = (Module)session.get(Module.class, moduleId);
		tx.commit();
		session.close();
		return module;
	}
}
