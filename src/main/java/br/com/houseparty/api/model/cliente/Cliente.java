package br.com.houseparty.api.model.cliente;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Usuario{

	@Column(name="CPF", nullable = true)
	private String cpf;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ID_ENDERECO")
	private Endereco endereco;
	
	
	public Cliente(String nome, String email, String telefone, String senha, String nome_usuario,Date dt_nascimento, Endereco endereco, String cpf) {
		super(nome, email, telefone, senha, nome_usuario, dt_nascimento);
		
		this.setCpf(cpf);
		this.setEndereco(endereco);
	}


	public Cliente() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
