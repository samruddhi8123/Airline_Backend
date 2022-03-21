package com.lti.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHTS")
public class Flight {

	@Id
	@GeneratedValue
    private long flight_Id;

	private String source;
    private String destination;
    private int depar_time;
    private int arrival_time;
    private int total_seats;
    private int duration;
    private int cabin;

	@ManyToOne
	@JoinColumn(name = "admin")
	private Admin admin;

	@OneToMany(mappedBy = "user")
	private List<User> users;

	@OneToMany(mappedBy = "booking")
	private List<Booking> booking;
	
	@OneToOne
	@JoinColumn(name="schedule_id")
	private Flight_Schedule flightshedule;

}