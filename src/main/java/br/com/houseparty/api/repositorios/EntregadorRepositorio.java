package br.com.houseparty.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.houseparty.api.model.Entregador;

public interface EntregadorRepositorio extends JpaRepository<Entregador, Long>{}
