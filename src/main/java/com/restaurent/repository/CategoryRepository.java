package com.restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.entity.CategoryDetails;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails, Long> {

}
