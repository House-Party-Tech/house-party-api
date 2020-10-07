package br.com.houseparty.api.model.cliente;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Usuario{

	@Column(name="CPF", nullable = false)
	private String cpf;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ENDERECO_ID_ENDERECO")
	private Endereco endereco;
	
	
	public Cliente(String nome, String email, String telefone, String senha, String nome_usuario,Date dt_nascimento, Endereco endereco, String cpf) {
		super(nome, email, telefone, senha, nome_usuario, dt_nascimento);
		
		this.setCpf(cpf);
		this.setEndereco(endereco);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
