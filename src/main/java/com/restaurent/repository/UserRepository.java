package com.restaurent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurent.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
