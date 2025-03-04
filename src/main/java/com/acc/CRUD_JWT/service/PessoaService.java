package com.acc.CRUD_JWT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.CRUD_JWT.model.Pessoa;
import com.acc.CRUD_JWT.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repository;

  @Transactional(readOnly = true)
  public List<Pessoa> findAll() {
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<Pessoa> getPessoaById(Long id) {
    return repository.findById(id);
  }

  @Transactional
  public Pessoa save(Pessoa pessoa) {
    return repository.save(pessoa);
  }

  @Transactional
  public Optional<Pessoa> update(Long id, Pessoa pessoaDetails) {
    return repository.findById(id).map(pessoa -> {
      pessoa.setNome(pessoaDetails.getNome());
      return repository.save(pessoa);
    });
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }

}
