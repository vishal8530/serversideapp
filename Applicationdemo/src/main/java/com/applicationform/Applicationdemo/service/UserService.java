package com.applicationform.Applicationdemo.service;

import java.util.List;

import com.applicationform.Applicationdemo.entity.User;

public interface UserService {
	
	// create
	public User createuser( User user);
	
	// Read -> List 
	public List<User> getallusers();
	
	// Get one User
	public User getoneuser(Long id);
	
	//update
	public User Updateuser(User user,Long id);
	
	//delete
	public void deleteuser(Long long1);
	
	
	public List<User> getalluserbycity( String district);

}
