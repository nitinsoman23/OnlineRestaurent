package com.restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurent.entity.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

}
