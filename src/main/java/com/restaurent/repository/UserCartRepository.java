package com.restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurent.entity.UserCartDetails;

public interface UserCartRepository extends JpaRepository<UserCartDetails, Long> {

}
