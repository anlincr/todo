package com.ty.ToDo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  @Column(unique = true)
  private String username;

  @NotBlank
  @Size(min = 6)
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<ToDo> todos = new ArrayList<>();

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }

  public List<ToDo> getTodos() {
	return todos;
  }

  public void setTodos(List<ToDo> todos) {
	this.todos = todos;
  }
  
}