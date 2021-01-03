package com.ubaid.jtech.userService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.userService.entity.AuthUser;
import com.ubaid.jtech.userService.entity.User;
import com.ubaid.jtech.userService.service.def.UserService;


@RestController
@RequestMapping("jtech/users")
public class UserController
{
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @return User on user id
	 */
	@GetMapping("/by/id/{userId}")
	public User getUserByUserId(@PathVariable("userId") Long userId)
	{
		int port = Integer.parseInt(env.getProperty("local.server.port"));
		User user = userService.findById(userId);
		user.setPort(port);
		return user;
	}
	
	/**
	 * 
	 * @return User on user id
	 */
	@GetMapping("/by/email/{userEmail}")
	public User getUserByUserEmail(@PathVariable("userEmail") String email)
	{
		int port = Integer.parseInt(env.getProperty("local.server.port"));
		User user = userService.findByEmail(email);
		user.setPort(port);
		return user;
	}

	@PostMapping("/auth")
	public ResponseEntity<User> getUser(@RequestBody AuthUser user)
	{
		System.err.println(user);
		return ResponseEntity.ok(userService.findUserByEmailAndPasswor(user.getEmail(), user.getPassword()));
	}
	
	@PostMapping("")
	public ResponseEntity<User> createUser(@RequestBody AuthUser user) {
		return ResponseEntity.ok(userService.createUser(user));		
	}
	
	/**
	 * 
	 * @return User on user id
	 */
	@GetMapping("")
	public List<User> getUserByUserEmail()
	{
		int port = Integer.parseInt(env.getProperty("local.server.port"));
		List<User> users = userService.findAll();
		users.parallelStream().forEach(s -> s.setPort(port));
		return users;
	}


}
