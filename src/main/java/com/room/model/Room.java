package com.room.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
  
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="roomId")
	private int id;
	
	@Column(name="roomname",length=50)
	private String name;
	
	@Column(name="lessee")
	private String lessee;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int id, String name, String lessee) {
		super();
		this.id = id;
		this.name = name;
		this.lessee = lessee;
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

	public String getLessee() {
		return lessee;
	}

	public void setLessee(String lessee) {
		this.lessee = lessee;
	}
	
	
	
}
