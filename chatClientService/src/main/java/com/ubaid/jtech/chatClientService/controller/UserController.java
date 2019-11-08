package com.ubaid.jtech.chatClientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.chatClientService.exception.JTechException;
import com.ubaid.jtech.chatClientService.feignProxy.UserProxy;
import com.ubaid.jtech.chatClientService.model.User;

@RestController
@RequestMapping("jtech/users")
@CrossOrigin("*")
public class UserController
{
	@Autowired
	private UserProxy userProxy;

	
	@GetMapping("/by/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email)
	{
		if (email == null)
			throw new JTechException("Enter a email");
		return new ResponseEntity<User>(userProxy.getUserByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers()
	{
		System.out.println("Line 38 UserController at Chat Client Service");
		return new ResponseEntity<List<User>>(userProxy.getUsers(), HttpStatus.OK);
	}
}
