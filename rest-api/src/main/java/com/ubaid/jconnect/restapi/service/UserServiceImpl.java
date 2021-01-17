package com.ubaid.jconnect.restapi.service;

import com.ubaid.jconnect.restapi.feignProxy.UserProxy;
import com.ubaid.jconnect.restapi.model.AuthUser;
import com.ubaid.jconnect.restapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserProxy userProxy;

    @Override
    public User getUserById(Long id) {
        return userProxy.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userProxy.getUserByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userProxy.getUsers();
    }

    @Override
    public User authUser(AuthUser user) {
        return userProxy.authUser(user);
    }

    @Override
    public User createUser(AuthUser user) {
        return userProxy.createUser(user);
    }
}
