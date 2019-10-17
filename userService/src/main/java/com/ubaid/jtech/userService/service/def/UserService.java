package com.ubaid.jtech.userService.service.def;

import java.util.List;

import com.ubaid.jtech.userService.entity.User;

public interface UserService {
	User findById(Long id);
	User findByEmail(String email);
	List<User> findAll();
}
