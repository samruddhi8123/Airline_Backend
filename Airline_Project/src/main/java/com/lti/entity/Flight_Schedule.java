package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT_SCHEDULE")
public class Flight_Schedule {
	@Id
	@GeneratedValue
	private int schedule_id;
	
	private LocalDate schedule_date;
	private LocalTime schedule_time;
	private int sets_avail;
	private String flight_no;
	
	@OneToOne
	@JoinColumn(name="flight_Id")
	private Flight flights;
	
	

}