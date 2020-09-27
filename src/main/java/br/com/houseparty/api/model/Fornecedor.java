package br.com.houseparty.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Usuario{

	@Column(name="CNPJ")
	private String cnpj;
	@ManyToOne
	@JoinColumn(name="ENDERECO")
	private Endereco endereco;
	
	public Fornecedor() {}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	
}
