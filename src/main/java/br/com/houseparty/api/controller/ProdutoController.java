package br.com.houseparty.api.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.model.produto.Produto;
import br.com.houseparty.api.repositorios.CategoriaRepositorio;
import br.com.houseparty.api.repositorios.ProdutoRepositorio;


@RestController
@RequestMapping({"/produto"})
public class ProdutoController {	

	private ProdutoRepositorio produtoRepositorio;
	private CategoriaRepositorio categoriaRepositorio;
	
	ProdutoController(ProdutoRepositorio repositorio, CategoriaRepositorio categoriaRepositorio){
		this.produtoRepositorio = repositorio;
		this.categoriaRepositorio = categoriaRepositorio;
	}

	@GetMapping
	public List<Produto> getProdutos(){
		return produtoRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = produtoRepositorio.findById(id);
		if(!produto.isPresent())
			return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/descricao")
	public ResponseEntity<?> buscarPorDescricao(@RequestParam(value = "descricao") String descricao){
		List<Produto> produtos = produtoRepositorio.findByDescricao(descricao);
		
		if(produtos.isEmpty())
			return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<?> buscarPorCategoria(@RequestParam(value = "categoria") String categoria){
		List<Categoria> categorias = categoriaRepositorio.findByDescricao(categoria);

		List<Produto> produtos =  produtoRepositorio.findByCategoria(categorias.get(0));
		
		if(produtos.isEmpty())
			return new ResponseEntity<>("Produtos não encontrados", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastroProduto(@RequestBody Produto produto) {
		
		List<Categoria> teste = categoriaRepositorio.findByDescricao(produto.getCategoria().getDescricao());
		
		if(!teste.isEmpty()) {
			List<Produto> produtoExistente = produtoRepositorio.findByDescricaoAndCategoria(produto.getDescricao(), produto.getCategoria());
			if(produtoExistente.isEmpty()) {
				produtoRepositorio.save(produto);
				return new ResponseEntity<>("Salvo com sucesso!", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Produto existente", HttpStatus.CONFLICT);

		}
		
		return new ResponseEntity<>("Categoria não existente", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/atualizar/{id}")
	public Optional<Object> alterarProduto(@RequestBody Produto atualizacao, @PathVariable Long id) {
		
		return produtoRepositorio.findById(id).map(produto -> {
			produto.setEan(atualizacao.getEan());
			produto.setDescricao(atualizacao.getDescricao());
			produto.setCategoria(atualizacao.getCategoria());
		       produtoRepositorio.save(produto);
		        
		       return new ResponseEntity<>("Produto alterado com sucesso!", HttpStatus.OK);
		 });


	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
		Optional<Produto> pesquisa = produtoRepositorio.findById(id);
		
		if(!pesquisa.isPresent())
			return new ResponseEntity<>("id não encontrado", HttpStatus.NOT_FOUND);
		
		produtoRepositorio.deleteById(id);
		return new ResponseEntity<>("Produto " + pesquisa.get().getDescricao() +", Id " + id + " excluido com sucesso", HttpStatus.OK);
	}
	
}
