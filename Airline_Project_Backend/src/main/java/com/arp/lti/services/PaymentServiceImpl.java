package com.arp.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arp.lti.beans.Payment;
import com.arp.lti.dao.PaymentDao;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao dao;
	
	@Override
	public Payment payBill(Payment p) {
		
		return dao.payBill(p) ;
	}

	
	
}
