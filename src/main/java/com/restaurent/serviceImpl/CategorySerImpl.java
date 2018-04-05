package com.restaurent.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.dao.CategoryDaoInt;
import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.service.CategorySerInt;

@Service
public class CategorySerImpl implements CategorySerInt {

	@Autowired
	CategoryDaoInt categoryDaoInt;
	
	@Override
	public List<CategoryDetails> getAllCategoryDetails() {
		
		return categoryDaoInt.getAllCategoryDetails();
	}

	@Override
	public void removeCategory(CategoryDetails categoryDetails) throws ResourceNotFoundException {
		
		categoryDaoInt.removeCategory(categoryDetails);

	}

	@Override
	public boolean insertCategoryDetails(CategoryDetails categoryDetails) {
		
		return categoryDaoInt.insertCategoryDetails(categoryDetails);

	}

	@Override
	public boolean updateCategoryDetails(CategoryDetails categoryDetails) throws ResourceNotFoundException {
		
		return categoryDaoInt.updateCategoryDetails(categoryDetails);
	}

}
