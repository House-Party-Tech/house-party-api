package br.com.houseparty.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.model.produto.Categoria_produto;
import br.com.houseparty.api.model.produto.Produto;
import br.com.houseparty.api.repositorios.CategoriaProdutoRepositorio;
import br.com.houseparty.api.repositorios.CategoriaRepositorio;
import br.com.houseparty.api.repositorios.ProdutoRepositorio;


@RestController
@RequestMapping({"/produto"})
public class ProdutoController {

	private ProdutoRepositorio repositorio;
	private CategoriaRepositorio categoriaRepositorio;
	
	ProdutoController(ProdutoRepositorio repositorio, CategoriaRepositorio categoriaRepositorio){
		this.repositorio = repositorio;
		this.categoriaRepositorio = categoriaRepositorio;
	}

	@GetMapping
	public List<Produto> getProdutos(){
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> getProduto(@PathVariable("id") Long id) {
		return repositorio.findById(id);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastroProduto(@RequestBody Produto produto) {
		
		List<Categoria> teste = categoriaRepositorio.findByDescricao(produto.getCategoria().getDescricao());
		
		if(!teste.isEmpty()) {
			repositorio.save(produto);
			return new ResponseEntity<>("Salvo com sucesso!", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Categoria não existente", HttpStatus.BAD_REQUEST);

	}
	
}
