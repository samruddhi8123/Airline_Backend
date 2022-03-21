package com.lti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
public class Booking {

	@Id
	private int booking_Id;
	private Date booking_time;
	private double booking_amount;
	private int schedule_id;
	

	@ManyToOne
	@JoinColumn(name="flight_Id")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User users;
	
	@OneToOne
	@JoinColumn(name="payment_Id")
	private Payment payment;
	
	@OneToMany(mappedBy ="seat_Id")
	private List<SeatMapping> seatmappings;
	
	
	
	
	


}
