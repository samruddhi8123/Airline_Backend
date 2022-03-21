package com.lti.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue
	private int transactionId;
  
	private String paymentid;
    private long totalCost;
	
	@OneToOne
	@JoinColumn(name = "booking_Id")
	private Booking booking;

}
