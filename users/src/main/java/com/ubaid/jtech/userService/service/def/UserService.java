package com.ubaid.jtech.userService.service.def;

import java.util.List;

import com.ubaid.jtech.userService.entity.AuthUser;
import com.ubaid.jtech.userService.entity.User;

public interface UserService {
	User findById(Long id);
	User findByEmail(String email);
	List<User> findAll();
	User findUserByEmailAndPasswor(String email, String password);
	User createUser(AuthUser user);
}
