package br.com.houseparty.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="entregador")
public class Entregador extends Usuario{

	@Column(name="CPF")
	private String cpf;

	public Entregador() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
}
