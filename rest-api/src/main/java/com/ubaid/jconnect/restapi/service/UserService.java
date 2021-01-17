package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.model.AuthUser;
import com.ubaid.jconnect.restapi.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getUsers();
    User authUser(AuthUser user);
    User createUser(AuthUser user);
}
