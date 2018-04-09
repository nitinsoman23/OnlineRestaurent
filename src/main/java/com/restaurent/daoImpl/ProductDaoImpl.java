package com.restaurent.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurent.dao.ProductDaoInt;
import com.restaurent.entity.ProductDetails;
import com.restaurent.exceptions.ResourceNotFoundException;
import com.restaurent.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDaoInt {

	private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Autowired
	ProductRepository productRepo;
	
	
	@Override
	public List<ProductDetails> getAllProductDetails() {
		
		return productRepo.findAll();
	}

	@Override
	public boolean insertProductDetails(ProductDetails productDetails) {
		
		boolean status = false;
		
		ProductDetails productDetails2 =  productRepo.save(productDetails);
		if(productDetails2 !=null) {
			status = true;
			log.info("Product details inserted "+productDetails.toString());
		}
	
		return status;
	}

	@Override
	public boolean updateProductDetails(ProductDetails productDetails) throws ResourceNotFoundException {
		
		boolean status = false;
		
		ProductDetails productDetails2 = productRepo.findById(productDetails.getProductId()).orElseThrow(()->new ResourceNotFoundException(productDetails.getProductId(),"updating"));
		productDetails2.setProductName(productDetails.getProductName());
		productDetails2.setProductDetail(productDetails.getProductDetail());
		productDetails2.setProductPrice(productDetails.getProductPrice());
		productDetails2.setCategorydetails(productDetails.getCategorydetails());
		productDetails2.setUpdationDate(new java.sql.Timestamp(System.currentTimeMillis()));
		ProductDetails productDetail1 = productRepo.save(productDetails2);
		
		if(productDetail1 != null) {
			status = true;
			log.info("Product details updated "+productDetails.toString());
		}
		
		return status;
	}

	@Override
	public boolean removeProductDetails(ProductDetails productDetails) throws ResourceNotFoundException {
		
		boolean status = false;
		
		ProductDetails productDetails2 = productRepo.findById(productDetails.getProductId()).orElseThrow(()->new ResourceNotFoundException(productDetails.getProductId(),"removing"));
		productRepo.delete(productDetails2);
		if(productDetails2 != null) {
			status = true;
		}
		
		return status;
	}

	@Override
	public ProductDetails getProducById(int id) throws ResourceNotFoundException {
		
		return productRepo.findById(new Long(id)).orElseThrow(()->new ResourceNotFoundException(id,"getting"));
	}

}
