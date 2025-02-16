package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

	@Id // firmary key 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// outo inc 
	@Column(name = "player_id") // col name in DB
	private int id;
	
	@Column(name = "player_name") //if you do not put this the column name will be "name"
	private String name; 
	
	@Column(name = "player_number")
	private int number;
	
	@Column(name = "player_address")
	private String address;
	
	@Column(name = "player_phone")
	private String phone;

	public Player() {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
