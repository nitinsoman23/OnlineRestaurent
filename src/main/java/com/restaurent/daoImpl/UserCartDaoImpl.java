package com.restaurent.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurent.dao.UserCartDaoInt;
import com.restaurent.entity.UserCartDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.repository.UserCartRepository;

@Repository
public class UserCartDaoImpl implements UserCartDaoInt {

	@Autowired
	UserCartRepository userCartRepo;

	@Override
	public boolean addToCart(UserCartDetails userCartDetails) {
		boolean status = false;
		UserCartDetails userCartDetails2 = userCartRepo.save(userCartDetails);
		if(userCartDetails2 != null) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean removeFromCart(UserCartDetails userCartDetails) throws ResourceNotFoundException {
		
		boolean status = false;
		UserCartDetails userCartDetails2 = userCartRepo.findById(userCartDetails.getUserCartId()).orElseThrow(()->new ResourceNotFoundException(userCartDetails.getUserCartId(),"removing"));
		userCartRepo.delete(userCartDetails2);
		if(userCartDetails2 !=null) {
			
			status = true;
		}
		
		return status;
	}

	
	@Override
	public List<UserCartDetails> getUserCartDetails() {
		
		return userCartRepo.findAll();
	}
	


}
