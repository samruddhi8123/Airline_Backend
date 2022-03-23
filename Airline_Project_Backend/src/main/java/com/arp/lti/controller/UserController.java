 package com.arp.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arp.lti.beans.User;
import com.arp.lti.exception.UserAlreadyExistsException;
import com.arp.lti.exception.UserNotFoundException;
import com.arp.lti.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController {     

	@Autowired
	private UserServiceImpl service;
   
	// http://localhost:8090/api/v1/users
	@GetMapping("/users")
	public List<User> getUserList() {
		return service.getAllUsers();
	}

	// http://localhost:8181/api/v1/addnewuser
	@PostMapping("/addnewuser")
	public String registerUser(@RequestBody User user) throws UserAlreadyExistsException{
		User u=service.registerUser(user);
		System.out.println("controller"+u);
		return "User registered successfully";
	}

	// http://localhost:8090/api/v1/users/{email}/{password}

	@GetMapping(path = "/users/{email}/{password}", produces = "application/json")
	public User loginUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) throws UserNotFoundException{
		return service.loginUser(email, password);
	}
/*
	// http://localhost:8090/api/v1/users/{id}
	@GetMapping(path = "/users/{id}", produces = "application/json")
	public User getUserById(@PathVariable(value = "id") int userid)  throws UserNotFoundException{
		return service.getUserById(userid);
	}

	// http://localhost:8090/api/v1/updateuser
	@PutMapping(path = "/updateuser")
	public String updatePassword(@RequestBody User user) throws UserNotFoundException{
		String email = user.getEmail();
		String password = user.getPassword();
		User u=service.updatePassword(email, password);
		return "Password updated successfully";
	}
	
	*/
}
