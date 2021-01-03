package com.ubaid.jtech.chatClientService.feignProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jtech.chatClientService.model.AuthUser;
import com.ubaid.jtech.chatClientService.model.User;

@FeignClient(contextId = "user-service-client", name = "api-gateway-server")
public interface UserProxy
{
	@GetMapping("user-service/jtech/users/by/id/{userId}")
	User getUserById(@PathVariable("userId") Long id);

	@GetMapping("user-service/jtech/users/by/email/{userEmail}")
	User getUserByEmail(@PathVariable("userEmail") String email);

	@GetMapping("user-service/jtech/users")
	List<User> getUsers();
	
	@PostMapping("user-service/jtech/users/auth")
	User authUser(@RequestBody AuthUser user);
	
	@PostMapping("user-service/jtech/users")
	User createUser(@RequestBody AuthUser user);

}
