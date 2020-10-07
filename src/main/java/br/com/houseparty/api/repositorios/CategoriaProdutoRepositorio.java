package br.com.houseparty.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.houseparty.api.model.produto.Categoria_produto;

public interface CategoriaProdutoRepositorio extends JpaRepository<Categoria_produto, Long>{
}
