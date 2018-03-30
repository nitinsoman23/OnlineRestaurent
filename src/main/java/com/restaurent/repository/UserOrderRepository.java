package com.restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurent.entity.UserOrderDetails;

public interface UserOrderRepository extends JpaRepository<UserOrderDetails, Long> {

}
