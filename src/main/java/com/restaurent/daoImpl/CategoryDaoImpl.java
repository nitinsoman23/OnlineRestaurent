package com.restaurent.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurent.dao.CategoryDaoInt;
import com.restaurent.entity.CategoryDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.repository.CategoryRepository;

@Repository
public class CategoryDaoImpl implements CategoryDaoInt {

	
	private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryDetails> getAllCategoryDetails() {
		
		return categoryRepository.findAll();
	}

	@Override
	public void removeCategory(CategoryDetails categoryDetails) throws ResourceNotFoundException {
	
		CategoryDetails categoryDetails2 = categoryRepository.findById(categoryDetails.getCategoryId()).orElseThrow(()->new ResourceNotFoundException(categoryDetails.getCategoryId(), "removing"));
		categoryRepository.delete(categoryDetails2);
			
		}

	@Override
	public boolean insertCategoryDetails(CategoryDetails categoryDetails) {
		
		boolean status = false;
		
		CategoryDetails categoryDetails2 = categoryRepository.save(categoryDetails);
		
		if(categoryDetails2!=null) {
			
			status = true;	
		}
		return status;
	}

	@Override
	public boolean updateCategoryDetails(CategoryDetails categoryDetails) throws ResourceNotFoundException {
		
		boolean updateStatus = false;
		CategoryDetails categoryDetails2 =  categoryRepository.findById(categoryDetails.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException(categoryDetails.getCategoryId(),"updating"));
		categoryDetails2.setCategoryName(categoryDetails.getCategoryName());
		categoryDetails2.setVegOrNon(categoryDetails.getVegOrNon());
		categoryDetails2.setUpdationDate(new java.sql.Timestamp(System.currentTimeMillis()));
		CategoryDetails categoryDetails21 = categoryRepository.save(categoryDetails);
		if(categoryDetails21 != null) {
			
			updateStatus = true;
		}
		return updateStatus ;
		
	}
	
	
	

}
