package com.restaurent.service;

import java.util.List;

import com.restaurent.entity.UserDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface UserSerInt {

	public List<UserDetails> getUserdetails();
	
	public boolean updateUserDetails(UserDetails userdetails) throws ResourceNotFoundException;
	
	public boolean insertUserDetails(UserDetails userdetails);
	
	public boolean removeUserDetails(UserDetails userdetails) throws ResourceNotFoundException;
	
	public UserDetails getUserById(int id) throws ResourceNotFoundException;
	
	
}
