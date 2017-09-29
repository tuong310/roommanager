package com.room.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="contract")
public class Contract {
 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="contractId")
	private int id;
	
	@Column(name="contractname", length=50)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contract(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
}
