package com.ubaid.jconnect.users.controller;


import java.util.List;
import java.util.Objects;

import com.ubaid.jconnect.users.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.jconnect.users.entity.AuthUser;
import com.ubaid.jconnect.users.service.def.UserService;

@RestController
@RequestMapping("jtech/users")
@RequiredArgsConstructor
public class UserController {
    private final Environment env;

    private final UserService userService;

    /**
     * @return User on user id
     */
    @GetMapping("/by/id/{userId}")
    public User getUserByUserId(@PathVariable("userId") Long userId) {
        int port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));
        User user = userService.findById(userId);
        user.setPort(port);
        return user;
    }

    /**
     * @return User on user id
     */
    @GetMapping("/by/email/{userEmail}")
    public User getUserByUserEmail(@PathVariable("userEmail") String email) {
        int port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));
        User user = userService.findByEmail(email);
        user.setPort(port);
        return user;
    }

    @PostMapping("/auth")
    public ResponseEntity<User> getUser(@RequestBody AuthUser user) {
        return ResponseEntity.ok(userService.findUserByEmailAndPasswor(user.getEmail(), user.getPassword()));
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody AuthUser user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    /**
     * @return User on user id
     */
    @GetMapping("")
    public List<User> getUserByUserEmail() {
        int port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));
        List<User> users = userService.findAll();
        users.parallelStream().forEach(s -> s.setPort(port));
        return users;
    }


}
