package br.com.houseparty.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.model.produto.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
	
    @Query(value = "select * from produto f where f.descricao = :descricao and f.categoria_id_categoria = :categoria", nativeQuery = true)
    List<Produto> findByDescricaoAndCategoria(@Param("descricao") String descricao, @Param("categoria") Categoria categoria);
    
    List<Produto> findByDescricao(String descricao);
    List<Produto> findByCategoria(Categoria categoria);
    
}
