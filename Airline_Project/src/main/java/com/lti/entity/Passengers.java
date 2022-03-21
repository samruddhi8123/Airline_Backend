package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Passengers")
public class Passengers {

	@Id
	@GeneratedValue
	private int passengerId;
	
    private String name;
    private int seatNo;
    private String gender;
    private int age;
    
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User user;
    
    

	

}