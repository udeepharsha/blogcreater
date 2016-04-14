package com.udeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udeep.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
