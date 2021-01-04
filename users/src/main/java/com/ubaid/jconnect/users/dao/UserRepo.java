package com.ubaid.jconnect.users.dao;

import java.util.Optional;

import com.ubaid.jconnect.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	Optional<User> findUserByEmailAndPassword(String email, String password);
}
