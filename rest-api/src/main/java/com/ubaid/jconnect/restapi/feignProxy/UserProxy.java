package com.ubaid.jconnect.restapi.feignProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jconnect.restapi.model.AuthUser;
import com.ubaid.jconnect.restapi.model.User;

@FeignClient(contextId = "user-service-client", name = "api-gateway")
public interface UserProxy {
    @GetMapping("jtech/users/by/id/{userId}")
    User getUserById(@PathVariable("userId") Long id);

    @GetMapping("jtech/users/by/email/{userEmail}")
    User getUserByEmail(@PathVariable("userEmail") String email);

    @GetMapping("jtech/users")
    List<User> getUsers();

    @PostMapping("jtech/users/auth")
    User authUser(@RequestBody AuthUser user);

    @PostMapping("jtech/users")
    User createUser(@RequestBody AuthUser user);
}
