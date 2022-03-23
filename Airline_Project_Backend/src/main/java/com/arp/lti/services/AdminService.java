package com.arp.lti.services;

import java.util.List;

import com.arp.lti.beans.Admin;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.exception.AdminNotFoundException;
import com.arp.lti.exception.FlightNotFoundException;
import com.arp.lti.exception.UserNotFoundException;

public interface AdminService {

	public List<Flight> getAllFlights();
	public Flight findById(int flightId) throws FlightNotFoundException;
	public String deleteFlight(int flightId)  throws FlightNotFoundException;
	public Admin loginAdmin(String email, String password) throws AdminNotFoundException;
	public Flight addFlight(Flight f);
	public Admin addAdmin(Admin a);
}

