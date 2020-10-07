package br.com.houseparty.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.houseparty.api.model.produto.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
	
	
}
