package com.eklakshya.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Integer totalNumberOfCridit;
	
	private Integer totalNumberOfHours;
	
	private String refBooks;

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

	public Integer getTotalNumberOfCridit() {
		return totalNumberOfCridit;
	}

	public void setTotalNumberOfCridit(Integer totalNumberOfCridit) {
		this.totalNumberOfCridit = totalNumberOfCridit;
	}

	public Integer getTotalNumberOfHours() {
		return totalNumberOfHours;
	}

	public void setTotalNumberOfHours(Integer totalNumberOfHours) {
		this.totalNumberOfHours = totalNumberOfHours;
	}

	public String getRefBooks() {
		return refBooks;
	}

	public void setRefBooks(String refBooks) {
		this.refBooks = refBooks;
	}
	

}
