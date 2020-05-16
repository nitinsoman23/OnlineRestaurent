package com.restaurent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.entity.UserCartDetails;
import com.restaurent.exceptions.ErrorResponse;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.exceptions.SuccessResponse;
import com.restaurent.service.UserCartServiceInt;

@RestController
public class UserCartController {

	@Autowired
	private UserCartServiceInt userCartSerInt;
	
	@GetMapping("/api/allCartdetails")
	public List<UserCartDetails> getAllUserCartDetails(){
		
		return userCartSerInt.getUserCartDetails();
	}
	
	@DeleteMapping("/api/removeUserCartdetails")
	public ResponseEntity<Object> removeCartDetails(@RequestBody UserCartDetails userCartDetails) throws ResourceNotFoundException{
		System.out.println("nitin2");
		boolean status = userCartSerInt.removeFromCart(userCartDetails);
		if(status) {
			
			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "User Cart Details removed Successfully"), HttpStatus.OK);
		}
		System.out.println("nitin3");
		System.out.println("nitin6");
		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in removing user cart details"),
				HttpStatus.UNAUTHORIZED);
	}
	
	
	public ResponseEntity<Object> addtoCart(@RequestBody UserCartDetails userCartDetails){
		
		boolean status = userCartSerInt.addToCart(userCartDetails);
		
		if (status) {

			return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.CREATED, "User Cart added Successfully"),
					HttpStatus.CREATED);

		}

		return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.UNAUTHORIZED, "Error while adding in User Cart Details"),
				HttpStatus.UNAUTHORIZED);
		
	}
	

	
	public void nitinFeature() {
		System.out.println("Nitin feature");
	}
	
}
