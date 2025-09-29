package com.ty.ToDo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ToDo {
  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  private String task;

  private boolean completed = false;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getTask() {
	return task;
  }

  public void setTask(String task) {
	this.task = task;
  }

  public boolean isCompleted() {
	return completed;
  }

  public void setCompleted(boolean completed) {
	this.completed = completed;
  }

  public User getUser() {
	return user;
  }

  public void setUser(User user) {
	this.user = user;
  }
  
}
