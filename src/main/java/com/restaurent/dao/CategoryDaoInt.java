package com.restaurent.dao;

import java.util.List;

import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ResourceNotFoundException;

public interface CategoryDaoInt{

	public List<CategoryDetails> getAllCategoryDetails()  ;
	
	public void removeCategory(CategoryDetails categoryDetails) throws ResourceNotFoundException;
	
	public void insertCategoryDetails(CategoryDetails categoryDetails);
	
	public boolean updateCategoryDetails(CategoryDetails categoryDetails) throws ResourceNotFoundException;
	
	
}
