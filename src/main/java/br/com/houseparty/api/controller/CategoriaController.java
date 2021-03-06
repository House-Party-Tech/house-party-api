package br.com.houseparty.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.houseparty.api.model.cliente.Cliente;
import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.model.produto.Produto;
import br.com.houseparty.api.repositorios.CategoriaRepositorio;
import br.com.houseparty.api.repositorios.ProdutoRepositorio;

@RestController
@RequestMapping({"/categoria"})
public class CategoriaController {

	private CategoriaRepositorio categoriaRepositorio;
	private ProdutoRepositorio produtoRepositorio;
	
	CategoriaController(CategoriaRepositorio categoriaRepositorio, ProdutoRepositorio produtoRepositorio){
		this.categoriaRepositorio = categoriaRepositorio;
		this.produtoRepositorio = produtoRepositorio;
	}
	
	@GetMapping
	public List<Categoria> getCategorias(){
		return categoriaRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Categoria> buscar(@PathVariable("id") Long id) {
		return categoriaRepositorio.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public void inserirCategoria(@RequestBody Categoria categoria) {
		List<Categoria> existeCategoria = categoriaRepositorio.findByDescricao(categoria.getDescricao()); 
		
		if(existeCategoria.isEmpty()) {
			categoriaRepositorio.save(categoria);
		}

	}
	
	@PutMapping("/atualizar/{id}")
	public Optional<Object> atualizaCliente(@RequestBody Categoria atualizacao, @PathVariable Long id) {
	    return categoriaRepositorio.findById(id).map(categoria -> {
	  
	        categoria.setDescricao(atualizacao.getDescricao());
	        return new ResponseEntity<>("Categoria alterada com sucesso!", HttpStatus.OK);
	      });
	    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
		Optional<Categoria> pesquisa = categoriaRepositorio.findById(id);
		List<Produto> pesquisaProduto = produtoRepositorio.findByCategoria(pesquisa.get());
		
		if(!pesquisa.isPresent()) {
			return new ResponseEntity<>("id não encontrado", HttpStatus.NOT_FOUND);
		}else if(!pesquisaProduto.isEmpty()) {
			return new ResponseEntity<>("Id procurado esta linkado a um produto (Exclua ou altere sua categoria)", HttpStatus.CONFLICT);
		}else {
			categoriaRepositorio.deleteById(id);
			return new ResponseEntity<>( "Id " + id + " excluido com sucesso", HttpStatus.OK);
		}
			


	}
}
	
	
	
	
	
	
	
	
