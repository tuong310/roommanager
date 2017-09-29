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
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="studentId")
	private int id;
	
	@Column(name="studentname", length=50)
	private String name;
	
	@Column(name="gender", length=50)
	private String gender;
	
	@Column(name="address", length=50)
	private String address;
	
	@Column(name="phone", length=50)
	private int phone;
	
	@Column(name="contract")
	private String contract;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roomId")
	private Room room;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Student(int id, String name, String contract) {
		super();
		this.id = id;
		this.name = name;
		this.contract = contract;
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
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	
	
}
