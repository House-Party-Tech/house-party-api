package br.com.houseparty.api.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String email;
	private String inscricao; 
	private String telefone;
	private String senha;
	private String nome_usuario;
	private Endereco endereco;
	private Date dt_cadastro;
	
	
}
