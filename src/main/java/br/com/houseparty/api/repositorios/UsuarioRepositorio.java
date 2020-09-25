package br.com.houseparty.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.houseparty.api.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {}
