package br.com.houseparty.api.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id_usuario;
	
	@Column(name="NOME")
	private String nome;
	@Column(name="EMAIL")
	private String email;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="SENHA")
	private String senha;
	@Column(name="NOME_USUARIO")
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dt_nascimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_CADASTRO")
	private Calendar dt_cadastro;
	
	public Usuario(String nome, String email, String telefone, String senha, String nome_usuario, Calendar dt_nascimento) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.usuario = nome_usuario;
		this.dt_nascimento = dt_nascimento;
		
		this.dt_cadastro = Calendar.getInstance();
	}
	
	public Usuario() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome_usuario() {
		return usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.usuario = nome_usuario;
	}
	
	
	
	
}
