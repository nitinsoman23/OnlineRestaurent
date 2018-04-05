package com.restaurent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ErrorResponse;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.exceptions.SuccessResponse;
import com.restaurent.service.CategorySerInt;

@RestController
public class CategoryController {

	@Autowired
	CategorySerInt categorySerInt;

	
	@PostMapping("/api/createCategory")
	public ResponseEntity<CategoryDetails> createCategoryDetails(@RequestBody CategoryDetails categoryDetails) {

		boolean status = categorySerInt.insertCategoryDetails(categoryDetails);

		if (status) {

			return new ResponseEntity<CategoryDetails>(categoryDetails, HttpStatus.CREATED);

		}
		return new ResponseEntity<CategoryDetails>(categoryDetails, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/api/getAllcategoryDetails")
	public List<CategoryDetails> getAllCategoryDetails() {

		return categorySerInt.getAllCategoryDetails();

	}

	@PutMapping("/api/updateCategoryDetails")
	public ResponseEntity<Object> updateCategoryDetails(@RequestBody CategoryDetails categoryDetails)
			throws ResourceNotFoundException {

		boolean statusCode = categorySerInt.updateCategoryDetails(categoryDetails);
		if (statusCode == true) {

			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "Category Details Updated Successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in updating categoryDetails"),
				HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/api/removeCategoryDetails")
	public ResponseEntity<Object> removeCategoryDetails(@RequestBody CategoryDetails categoryDetails) throws ResourceNotFoundException{
		
		categorySerInt.removeCategory(categoryDetails);
		
		return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.OK, "Category Details Removed Successfully"), HttpStatus.OK);
		
	}

}
