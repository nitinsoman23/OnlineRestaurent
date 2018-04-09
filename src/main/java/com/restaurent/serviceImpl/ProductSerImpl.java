package com.restaurent.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.dao.ProductDaoInt;
import com.restaurent.entity.ProductDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.service.ProductSerInt;

@Service
public class ProductSerImpl implements ProductSerInt {

	@Autowired
	ProductDaoInt productDaoInt;

	@Override
	public List<ProductDetails> getAllProductDetails() {
		
		return productDaoInt.getAllProductDetails();
	}

	@Override
	public boolean insertProductDetails(ProductDetails productDetails) {
		
		return productDaoInt.insertProductDetails(productDetails);
	}

	@Override
	public boolean updateProductDetails(ProductDetails productDetails) throws ResourceNotFoundException {
	
		return productDaoInt.updateProductDetails(productDetails);
	}

	@Override
	public boolean removeProductDetails(ProductDetails productDetails) throws ResourceNotFoundException {
		
		return productDaoInt.removeProductDetails(productDetails);
	}

	@Override
	public ProductDetails getProducById(int id) throws ResourceNotFoundException {
		
		return productDaoInt.getProducById(id);
	}
	
	
	

}
