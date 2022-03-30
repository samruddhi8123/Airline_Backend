package com.arp.lti.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arp.lti.beans.Booking;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.beans.sFlight;
import com.arp.lti.dao.BookingDao;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao dao;

	// @Override
	// public List<Flight> searchFlight(String source, String destination, Date
	// departureDate, String travelClass) {
	// // TODO Auto-generated method stub
	// return dao.searchFlight(source, destination, departureDate, travelClass);
	// }

	@Override
	public Booking addBooking(Booking b) {
		return dao.addBooking(b);
	}

	@Override
	public List<Flight> searchFlight(sFlight sf) {
		// TODO Auto-generated method stub
		return dao.searchFlight(sf);
	}

	@Override
	public List<Booking> viewBooking(int userId) {
		// TODO Auto-generated method stub
		return dao.viewBooking(userId);
	}

	/*@Override
	public String deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		return dao.deleteBooking(bookingId);
	}*/

	// @Override
	// public long addBookings(Booking b, String travelClass, int flightId, int
	// userId) {
	// // TODO Auto-generated method stub
	// return dao.addBookings(b, travelClass, flightId, userId);
	// }
}