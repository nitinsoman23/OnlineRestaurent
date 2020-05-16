package com.restaurent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.entity.UserDetails;
import com.restaurent.exceptions.ErrorResponse;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.exceptions.SuccessResponse;
import com.restaurent.service.UserSerInt;

@RestController
public class UserController {

	@Autowired
	UserSerInt userSerInt;
	
	
	@GetMapping("/api/getUserDetails")
	public List<UserDetails> getAllUserDetails(){
		return userSerInt.getUserdetails();
	}
	
	
	@PostMapping("/api/insertUser")
	public ResponseEntity<Object> insertUserDetails(@RequestBody UserDetails userDetails){
	boolean status = userSerInt.insertUserDetails(userDetails);
		if(status) {
			return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.CREATED, "User Details created Successfully"),
					HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.UNAUTHORIZED, "Error while creating UserDetails"),
				HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/api/updateUser")
	public ResponseEntity<Object> updateUserDetails(@RequestBody UserDetails userDetails) throws ResourceNotFoundException{
		boolean status = userSerInt.updateUserDetails(userDetails);
		if (status) {
			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "User Details Updated Successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in updating User details"),
				HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/api/deleteUser")
	public ResponseEntity<Object> removeUserDetails(@RequestBody UserDetails userDetails) throws ResourceNotFoundException{
		boolean status = userSerInt.removeUserDetails(userDetails);
		if (status) {

			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "User Details removed Successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in removing User details"),
				HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/api/getUserById/{id}")
	public UserDetails getUserById(@PathVariable("id") int id) throws ResourceNotFoundException {
		System.out.println("Nitin current controller");
		return userSerInt.getUserById(id);
	}
	
	
}
