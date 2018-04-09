package com.restaurent.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.dao.UserCartDaoInt;
import com.restaurent.entity.UserCartDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.service.UserCartServiceInt;

@Service
public class UserCartSerImpl implements UserCartServiceInt {

	@Autowired
	UserCartDaoInt userCartDao;
	
	@Override
	public boolean addToCart(UserCartDetails userCartDetails) {

		return userCartDao.addToCart(userCartDetails);
	}

	@Override
	public boolean removeFromCart(UserCartDetails userCartDetails) throws ResourceNotFoundException {
		
		return userCartDao.removeFromCart(userCartDetails);

	}

	@Override
	public List<UserCartDetails> getUserCartDetails() {
		
		return userCartDao.getUserCartDetails();
	}

}
