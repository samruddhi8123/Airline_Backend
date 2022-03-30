package com.arp.lti.dao;

import java.util.List;

import com.arp.lti.beans.User;
import com.arp.lti.exception.UserAlreadyExistsException;
import com.arp.lti.exception.UserNotFoundException;

public interface UserDao {
	public List<User> getAllUsers();
	public User registerUser(User u) throws UserAlreadyExistsException;
	public User updatePassword(String email, String password) throws UserNotFoundException;
	public User getUserById(int id)  throws UserNotFoundException;
	public User loginUser(String email, String password)  throws UserNotFoundException;
}
