package com.eklakshya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;
import org.springframework.http.HttpStatus;

import com.eklakshya.model.Student;
import com.eklakshya.repository.StudentDAO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public @ResponseBody Student getStudentDetails(@PathVariable("id")Integer studentId) {
		Student student = studentDAO.getStudentDetails(studentId);
		if (student == null) {
			throw new StudentNotFoundException();
		}
		return student;
	}
	@RequestMapping(value="/student1/", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student)  {
		try {
			studentDAO.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@RequestMapping(value="/student/", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createStudentAndResponse(HttpServletRequest request, HttpServletResponse response, 
			@RequestBody Student student)  {
		try {
			studentDAO.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String uri = getURIForChildResource(request, student.getId());
		response.addHeader("Location", uri);
	}
	
	private String getURIForChildResource(HttpServletRequest request, 
		       Object childIdentifier) {
		StringBuffer url = request.getRequestURL();
		UriTemplate template = new UriTemplate(url.append("/{childId}").toString());
		return template.expand(childIdentifier).toASCIIString();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
	public class StudentNotFoundException extends RuntimeException {
	  //Add any code if required.
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.NO_CONTENT )
	public void deleteStudent(@PathVariable("id")Integer studentId) {
		Student student = studentDAO.getStudentDetails(studentId);
		if (student == null) {
			throw new StudentNotFoundException();
		}
		
		try {
			studentDAO.delete(student);
		} catch (Exception e) {
			// Can't delete the Student Record
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/student/", method=RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	public void updateStudent(@RequestBody Student student) {
		try {
			studentDAO.update(student);
		} catch (Exception e) {
			// Either Student record does not exist or issue while updating record
			e.printStackTrace();
		}
		
	}
}
