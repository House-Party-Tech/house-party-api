package br.com.houseparty.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.houseparty.api.model.produto.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
	List<Categoria> findByDescricao (String descricao);
}
