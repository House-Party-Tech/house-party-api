package br.com.houseparty.api.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Produto {
	@Id
	@GeneratedValue
	private long id_produto;
	private String descricao;
	private long ean;
	private int qtd;
	private double preco;
	private Categoria id_categoria;
	
	

}
