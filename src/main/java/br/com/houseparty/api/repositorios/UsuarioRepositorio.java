package br.com.houseparty.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.houseparty.api.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {}
