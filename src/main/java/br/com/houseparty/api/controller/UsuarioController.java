package br.com.houseparty.api.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.houseparty.api.model.Cliente;
import br.com.houseparty.api.model.Usuario;

@RestController
public class UsuarioController {

	
	@GetMapping("/usuario/cliente")
	List<Cliente> getCliente(){
		
	}
	
	@PostMapping("/usuario/cliente")
	Cliente postCliente(@RequestBody Usuario cliente) {
		
	}
	
}
