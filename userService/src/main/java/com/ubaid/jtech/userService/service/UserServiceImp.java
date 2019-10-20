package com.ubaid.jtech.userService.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.jtech.userService.dao.UserRepo;
import com.ubaid.jtech.userService.entity.AuthUser;
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

	@Override
	public User findUserByEmailAndPasswor(String email, String password) {
		return userRepo.findUserByEmailAndPassword(email, password).get();
	}

	@Override
	public User createUser(AuthUser user) {
		String name = user.getEmail().substring(0, user.getEmail().indexOf('@'));
		User user2  = new User(name, name, name, user.getEmail(), user.getPassword(), "https://res.cloudinary.com/student1234567/image/upload/v1571599822/avatar.jpg", false, false, null, getCurrentTimestamp());
		return userRepo.save(user2);
	}
	
	private Timestamp getCurrentTimestamp()
	{
		Date date= new Date();		 
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}


}
