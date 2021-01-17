package com.ubaid.jconnect.restapi.controller;

import java.util.List;

import com.ubaid.jconnect.restapi.model.User;
import com.ubaid.jconnect.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.restapi.model.AuthUser;

@RestController
@RequestMapping("jtech/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/by/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<User> authUser(@RequestBody AuthUser user) {
        return ResponseEntity.ok(userService.authUser(user));
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody AuthUser user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
