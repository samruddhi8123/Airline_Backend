package com.arp.lti.controller;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arp.lti.beans.Booking;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.beans.sFlight;
import com.arp.lti.services.BookingService;
import com.arp.lti.services.UserServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class BookingController {
	
	
	@Autowired
	private BookingService service;

	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking b)
	{
		return service.addBooking(b);
	}
	
	@PostMapping("/sFlight" )
	public List<Flight> getFlightList(@RequestBody sFlight sf)
	{
		return service.searchFlight(sf);
	}
	
	@GetMapping("/bookings/{userId}")
	public List<Booking> getBookingList(@PathVariable(value="userId") int userId)
	{
		return service.viewBooking(userId);
	}

	@DeleteMapping("/bookingdelete/{id}")
	public String deleteBooking(@PathVariable(value="id") int bookingId) 
	{
		return service.deleteBooking(bookingId);
	}
	
}