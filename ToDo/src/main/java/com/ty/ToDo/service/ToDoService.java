package com.ty.ToDo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ToDo.entity.ToDo;
import com.ty.ToDo.entity.User;
import com.ty.ToDo.repository.ToDoRepository;

@Service
public class ToDoService {
  @Autowired ToDoRepository todoRepo;

  public List<ToDo> getTodos(User user) {
    return todoRepo.findByUser(user);
  }

  public void addTodo(ToDo todo, User user) {
    todo.setUser(user);
    todoRepo.save(todo);
  }
}
