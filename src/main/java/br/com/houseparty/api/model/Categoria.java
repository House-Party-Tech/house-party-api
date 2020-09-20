package br.com.houseparty.api.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private long id_categoria;
	private String nome;
	private String descricao;	
}
