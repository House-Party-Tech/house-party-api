package br.com.houseparty.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.houseparty.api.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByUsuario(String usuario);
	List<Cliente> findByEmail(String email);
	
    @Query(value = "select * from Cliente f where f.nome_usuario = :usuario and f.senha = :senha", nativeQuery = true)
    List<Cliente> findByUsuarioAndSenha(@Param("usuario") String usuario, @Param("senha") String senha);
    
    @Query(value = "select * from Cliente f where f.nome_usuario = :usuario and f.email = :email", nativeQuery = true)
    List<Cliente> findByUsuarioAndEmail(@Param("usuario") String usuario, @Param("email") String email);
}