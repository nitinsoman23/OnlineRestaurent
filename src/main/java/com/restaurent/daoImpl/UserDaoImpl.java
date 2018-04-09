package com.restaurent.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurent.dao.UserDaoInt;
import com.restaurent.entity.UserDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDaoInt {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserDetails> getUserdetails() {
		return userRepository.findAll();
	}

	@Override
	public boolean updateUserDetails(UserDetails userdetails) throws ResourceNotFoundException {
		
		boolean status = false;
		UserDetails userdetails2 = userRepository.findById(userdetails.getUserId()).orElseThrow(()->new ResourceNotFoundException(userdetails.getUserId(),"updating"));
		userdetails2.setFirstName(userdetails.getFirstName());
		userdetails2.setLastName(userdetails.getLastName());
		userdetails2.setEmailId(userdetails.getEmailId());
		userdetails2.setMobileNo(userdetails.getMobileNo());
		userdetails2.setPassword(userdetails.getPassword());
		userdetails2.setAccess(userdetails.getAccess());
		userdetails2.setUpdationDate(new java.sql.Timestamp(System.currentTimeMillis()));
		UserDetails userdetails1 = userRepository.save(userdetails2);
		if(userdetails1 !=null) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean insertUserDetails(UserDetails userdetails) {
		boolean status = false;
		UserDetails userDetails = userRepository.save(userdetails);
		if(userDetails !=null) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean removeUserDetails(UserDetails userdetails) throws ResourceNotFoundException {
		
		boolean status = false;
		
		UserDetails userdetails2 = userRepository.findById(userdetails.getUserId()).orElseThrow(()->new ResourceNotFoundException(userdetails.getUserId() ,"removing"));
		
		userRepository.delete(userdetails2);
		if(userdetails2 != null) {
			
			status = true;
		}
		
		return status;
	}

	@Override
	public UserDetails getUserById(int id) throws ResourceNotFoundException {
		
		UserDetails userdetails2 = userRepository.findById(new Long(id)).orElseThrow(()->new ResourceNotFoundException(id ,"removing"));
		return userdetails2;
	}

}
