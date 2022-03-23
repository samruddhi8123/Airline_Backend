package com.arp.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arp.lti.beans.Admin;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.exception.AdminNotFoundException;
import com.arp.lti.exception.FlightNotFoundException;
import com.arp.lti.services.AdminServiceImpl;
import com.arp.lti.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl service;
	
	//http://localhost:8090/api/v1/flights
	@GetMapping("/flights")
	public List<Flight> getFlightList()
	{
		return service.getAllFlights();
	}
	
	@GetMapping("/flights/{id}")
	public Flight getFlightById(@PathVariable(value="id") int flightId) throws FlightNotFoundException{
		return service.findById(flightId);
	}
	
	@DeleteMapping("/flightdelete/{id}")
	public String deleteFlights(@PathVariable(value="id") int flightId) throws FlightNotFoundException
	{  System.out.println(flightId);
	   String s=service.deleteFlight(flightId);
	System.out.println(s);	
	//return service.deleteFlight(flightId);
		return s;
	}
	
	
	@GetMapping(path = "/admin/{email}/{password}" , produces = "application/json")
	public Admin loginAdmin(@PathVariable(value="email")String email, @PathVariable(value="password")String password) throws AdminNotFoundException
	{
		return service.loginAdmin(email,password);
	}
	
	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight f)
	{
		return service.addFlight(f);
	}
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin a)
	{
		return service.addAdmin(a);
	}
}
