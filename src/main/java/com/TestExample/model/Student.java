package com.TestExample.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	 @Id
	private int id;
	private String name;
	private String domain;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Student(int id, String name, String domain) {

		this.id = id;
		this.name = name;
		this.domain = domain;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", domain=" + domain + "]";
	}

	
	
}
