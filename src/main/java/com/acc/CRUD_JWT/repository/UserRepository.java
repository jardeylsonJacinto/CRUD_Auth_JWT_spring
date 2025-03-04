package com.acc.CRUD_JWT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.CRUD_JWT.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByLogin(String login);
}
