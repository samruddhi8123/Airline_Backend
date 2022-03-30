package com.arp.lti.services;

import java.util.Date;
import java.util.List;

import com.arp.lti.beans.Booking;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.beans.sFlight;

public interface BookingService {

	//public List<Flight> searchFlight(String source, String destination,Date departureDate,String travelClass);
	public List<Flight> searchFlight(sFlight sf);
	public List<Booking> viewBooking(int userId);
	//public long addBookings(Booking b,String travelClass, int flightId, int userId);
	//public String deleteBooking(int bookingId);
	public Booking addBooking(Booking b);


}
