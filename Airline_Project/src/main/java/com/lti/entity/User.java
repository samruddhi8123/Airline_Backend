package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue
	private int user_Id;
	private String user_Fname;
	private String user_Lname;
	private int user_age;
	private String user_gender;
	private String user_email;
	private String user_address;
	private String user_password;
	private int flight_no;

	@OneToMany(mappedBy= "passenger")
	private List<Passengers> passenger;
	
	@ManyToOne
	@JoinColumn(name="flight_Id")
	private Flight flights;
	
	@OneToMany(mappedBy="booking")
	private Booking booking;

}