package br.com.houseparty.api.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.houseparty.api.model.cliente.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNome(String nome);
	
    @Query(value = "select * from cliente f where f.nome_usuario = :usuario", nativeQuery = true)
	Optional<Cliente> findByUsuario(@Param("usuario") String usuario);

	Optional<Cliente> findByEmail(String email);
	
    @Query(value = "select * from cliente f where f.nome_usuario = :usuario and f.senha = :senha", nativeQuery = true)
    List<Cliente> findByUsuarioAndSenha(@Param("usuario") String usuario, @Param("senha") String senha);
    
    @Query(value = "select * from cliente f where f.nome_usuario = :usuario and f.email = :email", nativeQuery = true)
    List<Cliente> findByUsuarioAndEmail(@Param("usuario") String usuario, @Param("email") String email);
    
}
