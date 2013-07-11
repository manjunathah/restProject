package com.eklakshya;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.eklakshya.model.Module;
import com.eklakshya.model.Student;

public class RestClientTest {
private static final String BASE_URL = "http://localhost:8080/restProject/studentSystem";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testStudentDetails() {
		String url = BASE_URL + "/student/1";
		String url_put = BASE_URL + "/student/";
		String url_delete = BASE_URL + "/student/7";
		Student student = null;
		try {
			student = restTemplate.getForObject(url, Student.class );
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("Name: " + student.getName());
		System.out.println("email ID : " + student.getEmailId());
		
		student.setName("Michael Isvy");
		restTemplate.put(url_put, student);
		
		restTemplate.delete(url_delete);
	}
	
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		
		student.setAddress("Spring People");
		student.setCourseName("Core Spring");
		student.setEmailId("manjunath@gmail.com");
		student.setName("Manjunath");
		
		Module module = new Module();
		module.setName("Spring REST");
		module.setRefBooks("RESTful WebServices");
		module.setTotalNumberOfCridit(10);
		module.setTotalNumberOfHours(200);
		Set<Module> list = new HashSet<Module>();
		list.add(module);
		
		Module module2 = new Module();
		module2.setName("Spring MVC");
		module2.setRefBooks("Spring MVC in 10 days");
		module2.setTotalNumberOfCridit(10);
		module2.setTotalNumberOfHours(200);
		list.add(module2);
		student.setEnrolledModules(list);
		
		String url = BASE_URL + "/student/";
		try {
			URI loc = restTemplate.postForLocation(url, student);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
