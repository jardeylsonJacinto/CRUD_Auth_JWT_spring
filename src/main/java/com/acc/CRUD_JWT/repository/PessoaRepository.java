package com.acc.CRUD_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.CRUD_JWT.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
