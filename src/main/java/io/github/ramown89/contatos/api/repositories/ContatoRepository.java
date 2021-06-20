package io.github.ramown89.contatos.api.repositories;

import org.springframework.stereotype.Repository;

import io.github.ramown89.contatos.api.models.Contato;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
