package com.arp.lti.dao;

import java.util.List;

import com.arp.lti.beans.Admin;
import com.arp.lti.beans.Flight;
import com.arp.lti.exception.AdminNotFoundException;
import com.arp.lti.exception.FlightNotFoundException;


public interface AdminDao {

	
	public List<Flight> getAllFlights();
	public Flight getFlightById(int flightId) throws FlightNotFoundException;
	public String deleteFlightbyId(int flightId) throws FlightNotFoundException;
	public Admin loginAdmin(String email, String password) throws AdminNotFoundException;
	public Flight addFlight(Flight f);
	public Admin addAdmin(Admin a);
}
