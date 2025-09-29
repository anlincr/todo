package com.ty.ToDo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ToDo.entity.ToDo;
import com.ty.ToDo.entity.User;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
	  List<ToDo> findByUser(User user);

	  
	}