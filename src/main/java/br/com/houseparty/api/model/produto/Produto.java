package br.com.houseparty.api.model.produto;

import java.util.Base64;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "ID_PRODUTO")
	private Long id_produto;
	
	@Column(name = "EAN", nullable = false)
	private String ean;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@ManyToOne
	private Categoria categoria;
	
	@Lob
	@Column(name= "IMAGEM", nullable = false)
	private String imagemProduto;
	
	public Produto() {}
	
	public Produto(String ean, String descricao) {
		this.setEan(ean);
		this.setDescricao(descricao);
	}
	
	public String getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
