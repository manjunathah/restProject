package com.eklakshya;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eklakshya.model.Module;
import com.eklakshya.model.Student;
import com.eklakshya.repository.StudentDAO;

public class TestStudentDAO {

	private ApplicationContext context = null;
	@Test
	public void setup() {
		context = new ClassPathXmlApplicationContext("file:E:\\Softwares\\core-spring-3.2.b-b1-RELEASE\\core-spring-3.2.b-b1-RELEASE\\restProject\\src\\main\\webapp\\WEB-INF\\app-config.xml",
				"file:E:\\Softwares\\core-spring-3.2.b-b1-RELEASE\\core-spring-3.2.b-b1-RELEASE\\restProject\\src\\main\\webapp\\WEB-INF\\mvc-config.xml" );
	
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		Student student = new Student();
		
		student.setAddress("BVBCET, HUBLI");
		student.setCourseName("VLSI Design");
		student.setEmailId("manjunp123@gmail.com");
		student.setName("Manjunath");
		
		Module module = new Module();
		module.setName("STD Cell");
		module.setRefBooks("Book1");
		module.setTotalNumberOfCridit(10);
		module.setTotalNumberOfHours(200);
		Set<Module> list = new HashSet<Module>();
		list.add(module);
		
		Module module2 = new Module();
		module2.setName("STD Cell");
		module2.setRefBooks("Book1");
		module2.setTotalNumberOfCridit(10);
		module2.setTotalNumberOfHours(200);
		list.add(module2);
		student.setEnrolledModules(list);
		try {
			studentDAO.save(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
