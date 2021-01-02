package com.ubaid.jtech.userService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubaid.jtech.userService.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	Optional<User> findUserByEmailAndPassword(String email, String password);
}
