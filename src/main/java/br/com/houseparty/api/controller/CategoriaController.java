package br.com.houseparty.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.repositorios.CategoriaRepositorio;
import br.com.houseparty.api.repositorios.ProdutoRepositorio;

@RestController
@RequestMapping({"/categoria"})
public class CategoriaController {

	private CategoriaRepositorio repositorio;
	
	CategoriaController(CategoriaRepositorio repositorio){
		this.repositorio = repositorio;
	}
	
	@GetMapping
	public List<Categoria> getCategorias(){
		return repositorio.findAll();
	}
	
	@GetMapping({"id"})
	public Optional<Categoria> buscar(@PathVariable("id") Long id) {
		return repositorio.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public void inserirCategoria(@RequestBody Categoria categoria) {
		List<Categoria> existeCategoria = repositorio.findByDescricao(categoria.getDescricao()); 
		
		if(existeCategoria.isEmpty()) {
			repositorio.save(categoria);
		}

	}
	
}
