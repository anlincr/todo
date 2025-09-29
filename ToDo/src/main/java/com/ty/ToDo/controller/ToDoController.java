package com.ty.ToDo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.ToDo.entity.ToDo;
import com.ty.ToDo.entity.User;
import com.ty.ToDo.repository.UserRepository;
import com.ty.ToDo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
public class ToDoController {
  @Autowired private ToDoService todoService;
  @Autowired private UserRepository userRepo;

  @GetMapping("/todos")
  public String listTodos(Model model, Principal principal) {
    User user = userRepo.findByUsername(principal.getName()).get();
    model.addAttribute("todos", todoService.getTodos(user));
    model.addAttribute("todo", new ToDo());
    return "todos";
  }

  @PostMapping("/todos")
  public String addTodo(@Valid @ModelAttribute ToDo todo, BindingResult result, Principal principal) {
    if (result.hasErrors()) return "todos";
    User user = userRepo.findByUsername(principal.getName()).get();
    todoService.addTodo(todo, user);
    return "redirect:/todos";
  }
}