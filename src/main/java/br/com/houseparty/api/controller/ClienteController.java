package br.com.houseparty.api.controller;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.houseparty.api.model.cliente.Cliente;
import br.com.houseparty.api.repositorios.ClienteRepositorio;


@RestController
@RequestMapping({"/cliente"})
public class ClienteController {
	
	private ClienteRepositorio clienteRepositorio;
	
	ClienteController(ClienteRepositorio usuarioRepositorio){
		this.clienteRepositorio = usuarioRepositorio;
	}
	
	@GetMapping
	public List<Cliente> getClientes() {
		return clienteRepositorio.findAll();
	}
		
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		if(!cliente.isPresent()) {
			return new ResponseEntity<>("Id não encontrado", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Cliente> retornaPorNome(@PathVariable("nome") String nome) {
		return clienteRepositorio.findByNome(nome);
	}
	
	@GetMapping("/email/{email}")
	public Optional<Cliente> retornaPorEmail(@PathVariable("email") String email){
		return clienteRepositorio.findByEmail(email);
	}

	@GetMapping("/usuario")
	public Optional<Cliente> retornaPorNomeUsuario(@RequestParam("usuario") String usuario) {
		return clienteRepositorio.findByUsuario(usuario);
	}

	@GetMapping("/autenticacao")
	public ResponseEntity<Map<String, String>> autenticacaoCliente(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha) {
		
		List<Cliente> pesquisa = clienteRepositorio.findByUsuarioAndSenha(usuario, senha);
		
		if(pesquisa.isEmpty())
			return new ResponseEntity<>(resposta("Resposta", "Usuario ou senha invalida"),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(resposta("Resposta", "Ok"),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Map<String, String>> cadastroCliente(@RequestBody Cliente cliente) {	
		
		Optional<Cliente> usuario = clienteRepositorio.findByUsuario(cliente.getUsuario());
		Optional<Cliente> email = clienteRepositorio.findByEmail(cliente.getEmail());
		
		if(usuario.isPresent()) {
			return new ResponseEntity<>(resposta("Resposta", "usuario '" + cliente.getUsuario() + "' já cadastrado"), HttpStatus.CONFLICT);
		} else if(email.isPresent()) {
			return new ResponseEntity<>(resposta("Resposta","Email '" + cliente.getEmail() + "' já cadastrado"), HttpStatus.CONFLICT);
		} else {
			clienteRepositorio.save(cliente);
			return new ResponseEntity<>(resposta("Resposta","Salvo com sucesso!"), HttpStatus.CREATED);
		}
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deletarCliente(@PathVariable Long id) {
		Optional<Cliente> pesquisa = clienteRepositorio.findById(id);
		
		if(!pesquisa.isPresent())
			return new ResponseEntity<>(resposta("Resposta", "id não encontrado"), HttpStatus.NOT_FOUND);
		
		clienteRepositorio.deleteById(id);
		return new ResponseEntity<>(resposta("Resposta", "Id " + id + " excluido com sucesso"), HttpStatus.OK);
	}
	
	@PutMapping("/atualizar/{id}")
	public Optional<Object> atualizaCliente(@RequestBody Cliente atualizacao, @PathVariable Long id) {
	    return clienteRepositorio.findById(id).map(cliente -> {
	    	        cliente.setNome(atualizacao.getNome());
	    	        cliente.setEmail(atualizacao.getEmail());
	    	        cliente.setUsuario(atualizacao.getUsuario());
	    	        cliente.setSenha(atualizacao.getSenha());
	    	        cliente.setTelefone(atualizacao.getTelefone());
	    	        cliente.setCpf(atualizacao.getCpf());
	    	        clienteRepositorio.save(cliente);
	    	        return new ResponseEntity<>(resposta("Resposta", "Usuário alterado com sucesso!"), HttpStatus.OK);
	    	      });
	}
	
	private Map<String, String> resposta(String titulo_resposta, String resposta) {
        Map<String, String> body = new HashMap<>();
        body.put(titulo_resposta, resposta);
        return body;
	}
	
}
