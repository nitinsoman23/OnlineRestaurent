package com.restaurent.service;

import java.util.List;

import com.restaurent.entity.ProductDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface ProductSerInt {

	public List<ProductDetails> getAllProductDetails();
	
	public boolean insertProductDetails(ProductDetails productDetails);
	
	public boolean updateProductDetails(ProductDetails productDetails) throws ResourceNotFoundException;
	
	public boolean removeProductDetails(ProductDetails productDetails) throws ResourceNotFoundException;
	
	public ProductDetails getProducById(int id) throws ResourceNotFoundException;
}
