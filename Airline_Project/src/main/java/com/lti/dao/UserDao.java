package com.lti.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.entity.User;



public interface UserDao extends JpaRepository<User, Integer>{

public User findByEmailId(String emailId);
public User findByEmailAndPassword(String emailId , String password);



}