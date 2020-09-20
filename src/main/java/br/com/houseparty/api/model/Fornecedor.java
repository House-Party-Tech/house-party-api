package br.com.houseparty.api.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Usuario{

	private Produto produto;
	private Conta conta_bancaria;
	
	public Fornecedor() {}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Conta getConta_bancaria() {
		return conta_bancaria;
	}

	public void setConta_bancaria(Conta conta_bancaria) {
		this.conta_bancaria = conta_bancaria;
	}
	
	
}
