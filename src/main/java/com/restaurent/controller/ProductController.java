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

import com.restaurent.entity.ProductDetails;
import com.restaurent.exceptions.ErrorResponse;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.exceptions.SuccessResponse;
import com.restaurent.service.ProductSerInt;

@RestController
public class ProductController {

	@Autowired
	ProductSerInt productSer;
	
	@GetMapping("/api/getProductdetails")
	public List<ProductDetails> getAllProductDetails(){
		
		return productSer.getAllProductDetails();
	}
	
	@PostMapping("/api/createProduct")
	public ResponseEntity<Object> insertProductDetails(@RequestBody ProductDetails product) {
		boolean status = productSer.insertProductDetails(product);
		if (status) {

			return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.CREATED, "Product created Successfully"),
					HttpStatus.CREATED);

		}

		return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.UNAUTHORIZED, "Error while creating product"),
				HttpStatus.UNAUTHORIZED);

	}
	
	@PutMapping("/api/updateProduct")
	public ResponseEntity<Object> updateProductDetails(@RequestBody ProductDetails product) throws ResourceNotFoundException{
		
		boolean status = productSer.updateProductDetails(product);
		if (status) {

			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "Product Details Updated Successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in updating product details"),
				HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/api/deleteProduct")
	public ResponseEntity<Object> removeProductDetails(@RequestBody ProductDetails product) throws ResourceNotFoundException{
		boolean status 	= productSer.removeProductDetails(product);
		if (status) {

			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK, "Product Details removed Successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(
				new ErrorResponse(HttpStatus.UNAUTHORIZED, "Error in removing product details"),
				HttpStatus.UNAUTHORIZED);
		
	}
	
	@GetMapping("/api/product/{id}")
	public ProductDetails getProductById(@PathVariable("id") int productId) throws ResourceNotFoundException {
		
		return productSer.getProducById(productId);
		
	}
	
	
	
}
