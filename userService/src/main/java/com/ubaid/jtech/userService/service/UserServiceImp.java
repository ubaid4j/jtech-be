package com.ubaid.jtech.userService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jtech.userService.dao.UserRepo;
import com.ubaid.jtech.userService.entity.User;
import com.ubaid.jtech.userService.service.def.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User findById(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email).get();
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

}
