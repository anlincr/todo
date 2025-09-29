package com.ty.ToDo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ty.ToDo.entity.User;
import com.ty.ToDo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
  @Autowired private UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
  }

  public void save(User user) {
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    userRepo.save(user);
  }
}