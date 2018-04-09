package com.restaurent.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.dao.UserDaoInt;
import com.restaurent.entity.UserDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.service.UserSerInt;

@Service
public class UserSerImpl implements UserSerInt {

	@Autowired
	UserDaoInt useDaoint;
	
	@Override
	public List<UserDetails> getUserdetails() {
	
		return useDaoint.getUserdetails();
	}

	@Override
	public boolean updateUserDetails(UserDetails userdetails) throws ResourceNotFoundException {
	
		return useDaoint.updateUserDetails(userdetails);
	}

	@Override
	public boolean insertUserDetails(UserDetails userdetails) {
		
		return useDaoint.insertUserDetails(userdetails);
	}

	@Override
	public boolean removeUserDetails(UserDetails userdetails) throws ResourceNotFoundException {
		
		return useDaoint.removeUserDetails(userdetails);
	}

	@Override
	public UserDetails getUserById(int id) throws ResourceNotFoundException {
		
		return useDaoint.getUserById(id);
	}

}
