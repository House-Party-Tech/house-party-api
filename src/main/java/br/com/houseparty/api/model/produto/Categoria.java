package br.com.houseparty.api.model.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue
	@Column(name = "ID_CATEGORIA")
	private Long id_categoria;
	@Column(name = "DESCRICAO")
	private String descricao;
	
	public Categoria() {}
	
	public Categoria(String descricao) {
		this.setDescricao(descricao);
	}
	
	public Long getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
