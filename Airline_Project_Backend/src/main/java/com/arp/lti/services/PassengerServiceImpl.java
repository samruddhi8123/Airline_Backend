package com.arp.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arp.lti.beans.Passenger;
import com.arp.lti.dao.PassengerDao;
import com.arp.lti.dao.PaymentDao;

@Service("passengerService")
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDao dao;
	
	@Override
	public Passenger addPassenger(Passenger p) {
		// TODO Auto-generated method stub
		return dao.addPassenger(p);
	}

}
