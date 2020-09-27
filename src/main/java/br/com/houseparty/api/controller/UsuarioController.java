package br.com.houseparty.api.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.houseparty.api.model.Cliente;
import br.com.houseparty.api.model.Usuario;
import br.com.houseparty.api.repositorios.ClienteRepositorio;


@RestController
@RequestMapping({"/usuario"})
public class UsuarioController {
	
	private ClienteRepositorio clienteRepositorio;
	
	UsuarioController(ClienteRepositorio usuarioRepositorio){
		this.clienteRepositorio = usuarioRepositorio;
	}
	
	
}
