package com.ubaid.jtech.chatClientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jtech.chatClientService.feignProxy.UserProxy;
import com.ubaid.jtech.chatClientService.model.User;

@RestController
@RequestMapping("jtech/users")
public class UserController
{
	@Autowired
	private UserProxy userProxy;

	
	@GetMapping("/by/email/{email}")
	public User getUserByEmail(@PathVariable("email") String email)
	{
		return userProxy.getUserByEmail(email);
	}
}
