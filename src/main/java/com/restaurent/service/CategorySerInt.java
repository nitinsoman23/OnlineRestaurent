package com.restaurent.service;

import java.util.List;

import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface CategorySerInt {

	public List<CategoryDetails> getAllCategoryDetails()  ;
	
	public void removeCategory(CategoryDetails categoryDetails) throws ResourceNotFoundException;
	
	public boolean insertCategoryDetails(CategoryDetails categoryDetails);
	
	public boolean updateCategoryDetails(CategoryDetails categoryDetails) throws ResourceNotFoundException;
	
	
}
