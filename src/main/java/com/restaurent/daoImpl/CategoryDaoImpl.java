package com.restaurent.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurent.dao.CategoryDaoInt;
import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.repository.CategoryRepository;

public class CategoryDaoImpl implements CategoryDaoInt {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryDetails> getAllCategoryDetails() {
		
		return categoryRepository.findAll();
	}

	@Override
	public void removeCategory(CategoryDetails categoryDetails) throws ResourceNotFoundException {
	
		CategoryDetails categoryDetails2 =  categoryRepository.findById(categoryDetails.getCategoryId()).orElseThrow(()->new ResourceNotFoundException(categoryDetails.getCategoryId()));
		categoryRepository.delete(categoryDetails2);
			
		}

	@Override
	public void insertCategoryDetails(CategoryDetails categoryDetails) {
		
		categoryRepository.save(categoryDetails);
		
	}

	@Override
	public boolean updateCategoryDetails(CategoryDetails categoryDetails) throws ResourceNotFoundException {
		
		CategoryDetails categoryDetails2 =  categoryRepository.findById(categoryDetails.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException(categoryDetails.getCategoryId()));
		categoryDetails2.setCategoryName(categoryDetails.getCategoryName());
		categoryDetails2.setVegOrNon(categoryDetails.getVegOrNon());
		categoryDetails2.setUpdationDate(new java.sql.Timestamp(System.currentTimeMillis()));
		categoryRepository.save(categoryDetails2);
		return false;
		
	}
	
	
	

}
