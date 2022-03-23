package com.lti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.entity.User;
import com.lti.service.UserService;


@RestController // we want only response so use restcontroller
public class UserController {
	
	@Autowired
   private UserService service;

	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/resisteruser")
	public User ResisterUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getUser_email();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.findUserByEmailId(tempEmailId);
			if (userobj != null) {
				throw new Exception("User with " + tempEmailId + "is alreay exist");
			}
		}
		User userobj = null;
		userobj = service.saveUser(userobj);
		return userobj;
	}

	//@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getUser_email();
		String tempPass = user.getUser_password();
		User userobj = null;
		if (tempEmailId != null && tempPass != null) {
			userobj = service.findByEmailAndPassword(tempEmailId, tempPass);
		}
		if (userobj == null) {
			throw new Exception("Bad credentials");
		}
		return userobj;
	}

}