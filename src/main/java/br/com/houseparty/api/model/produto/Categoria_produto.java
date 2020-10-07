package br.com.houseparty.api.model.produto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA_PRODUTO")
public class Categoria_produto {

	@Id
	@GeneratedValue
	@Column(name="ID_CATEGORIA_PRODUTO")
	private Long id_categoria_produto;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PRODUTO")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_CATEGORIA")
	private Categoria categoria;

	public Long getId_categoria_produto() {
		return id_categoria_produto;
	}

	public void setId_categoria_produto(Long id_categoria_produto) {
		this.id_categoria_produto = id_categoria_produto;
	}

	public Produto getId_produto() {
		return produto;
	}

	public void setId_produto(Produto id_produto) {
		this.produto = id_produto;
	}

	public Categoria getId_categoria() {
		return categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.categoria = id_categoria;
	}
	
	
}
