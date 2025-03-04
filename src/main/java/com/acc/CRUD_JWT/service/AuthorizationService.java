package com.acc.CRUD_JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acc.CRUD_JWT.model.User;
import com.acc.CRUD_JWT.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

  @Autowired
  UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByLogin(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

    return user; // A classe User já implementa UserDetails
  }
}
