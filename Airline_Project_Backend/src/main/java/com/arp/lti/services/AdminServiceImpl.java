package com.arp.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arp.lti.beans.Admin;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.dao.AdminDao;
import com.arp.lti.dao.AdminDaoImpl;
import com.arp.lti.dao.UserDao;
import com.arp.lti.exception.FlightNotFoundException;

@Service("flightService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	public List<Flight> getAllFlights() {
		return dao.getAllFlights();
	}

	public Flight findById(int flightId) throws FlightNotFoundException {
		return dao.getFlightById(flightId);
	}

	public String deleteFlight(int FlightId) throws FlightNotFoundException {
		return dao.deleteFlightbyId(FlightId);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public Flight addFlight(Flight f) {
		return dao.addFlight(f);
	}
	@Override
	public Admin addAdmin(Admin a) {
		return dao.addAdmin(a);
	}
}
