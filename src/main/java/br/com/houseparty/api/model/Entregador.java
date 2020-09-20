package br.com.houseparty.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="entregador")
public class Entregador extends Usuario{

	private Conta conta_bancaria;
	
	public Entregador() {}

	public Conta getConta_bancaria() {
		return conta_bancaria;
	}

	public void setConta_bancaria(Conta conta_bancaria) {
		this.conta_bancaria = conta_bancaria;
	}
	
	
}
