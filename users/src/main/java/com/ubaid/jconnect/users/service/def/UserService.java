package com.ubaid.jconnect.users.service.def;

import java.util.List;

import com.ubaid.jconnect.users.entity.User;
import com.ubaid.jconnect.users.entity.AuthUser;

public interface UserService {
	User findById(Long id);
	User findByEmail(String email);
	List<User> findAll();
	User findUserByEmailAndPasswor(String email, String password);
	User createUser(AuthUser user);
}
