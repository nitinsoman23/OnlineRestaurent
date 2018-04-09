package com.restaurent.service;

import java.util.List;

import com.restaurent.entity.UserCartDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface UserCartServiceInt {

	public boolean addToCart(UserCartDetails userCartDetails);
	
	public boolean removeFromCart(UserCartDetails userCartDetails) throws ResourceNotFoundException;
	
	public List<UserCartDetails> getUserCartDetails();
	
}
