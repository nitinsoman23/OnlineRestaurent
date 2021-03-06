package com.restaurent.dao;

import java.util.List;

import com.restaurent.entity.UserCartDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface UserCartDaoInt {

	public boolean addToCart(UserCartDetails userCartDetails);
	
	public boolean removeFromCart(UserCartDetails userCartDetails) throws ResourceNotFoundException;
	
	public List<UserCartDetails> getUserCartDetails();
	
}
