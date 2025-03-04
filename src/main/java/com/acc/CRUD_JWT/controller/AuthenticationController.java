package com.acc.CRUD_JWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acc.CRUD_JWT.config.TokenService;
import com.acc.CRUD_JWT.model.User;
import com.acc.CRUD_JWT.model.user.dtos.AuthenticationDTO;
import com.acc.CRUD_JWT.model.user.dtos.LoginResponseDTO;
import com.acc.CRUD_JWT.model.user.dtos.RegisterDTO;
import com.acc.CRUD_JWT.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository repository;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
    try {
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
      var auth = this.authenticationManager.authenticate(usernamePassword);

      var userDetails = (UserDetails) auth.getPrincipal();
      var user = (User) userDetails; // Convertendo UserDetails para User

      var token = tokenService.generateToken(user); // Passando o User para gerar o token

      return ResponseEntity.ok(new LoginResponseDTO(token)); // Passando o token para o DTO
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
    }
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
    if (this.repository.findByLogin(data.login()).isPresent()) {
      return ResponseEntity.badRequest().body("Usuário já existe!");
    }

    String encryptedPassword = passwordEncoder.encode(data.password());
    User newUser = new User(data.login(), encryptedPassword, data.role());

    this.repository.save(newUser);

    return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso.");
  }
}
