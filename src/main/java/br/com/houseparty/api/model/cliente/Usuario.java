package br.com.houseparty.api.model.cliente;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id_usuario; // Primary key
	
	@Column(name="NOME", nullable = true)
	private String nome; 
	@Column(name="EMAIL", nullable = true)
	private String email; 
	@Column(name="TELEFONE", nullable = true)
	private String telefone;
	@Column(name="SENHA", nullable = true)
	private String senha;
	@Column(name="NOME_USUARIO", nullable = true)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO", nullable = true)
	private Date dt_nascimento;
	
    @CreationTimestamp
    private Timestamp  createDateTime;
 
    @UpdateTimestamp
    private Timestamp  updateDateTime;
	
	public Usuario(String nome, String email, String telefone, String senha, String nome_usuario, Date dt_nascimento) {
		this.setNome(nome);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setUsuario(nome_usuario);
		this.setDt_nascimento(dt_nascimento);
	}
	
	public Usuario() {}
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}


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
	
	
	
	
}
