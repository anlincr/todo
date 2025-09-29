package com.ty.ToDo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ToDo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findByUsername(String username);
	}
