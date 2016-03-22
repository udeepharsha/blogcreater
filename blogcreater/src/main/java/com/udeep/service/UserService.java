package com.udeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udeep.repository.UserRepository;

import com.udeep.entity.User;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

}
