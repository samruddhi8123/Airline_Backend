package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SEAT_MAPPING")
public class SeatMapping {
	@Id
	private int seat_Id;
	private int seatNo;
	private int booking_Id;
	
	@ManyToOne
	@JoinColumn(name="booking_Id")
	private Booking booking;

}
