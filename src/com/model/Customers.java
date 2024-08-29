package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cId")
	private int id;
	@Column(name = "cName")
	private  String name;
	@Column(name = "cEmail")
	private String email;
	@Column(name = "cNumber")
	private int number;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}
	public Customers(String name, String email, int number) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
