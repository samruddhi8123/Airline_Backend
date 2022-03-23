package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.User;



@Service
public class UserService {
	
    @Autowired
	private UserDao dao;


	public User saveUser(User user) {
	return dao.save(user);

	}
	public User findUserByEmailId(String emailId) {
	return dao.findByEmailId(emailId);

	}
	public User findByEmailAndPassword(String emailId,String password) {
	return dao.findByEmailAndPassword(emailId ,password);


	}



}

