package com.eklakshya.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String courseName;
	
	private String emailId;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="module_id")
	private Set<Module> enrolledModules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Module> getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(Set<Module> enrolledModules) {
		this.enrolledModules = enrolledModules;
	}

}
