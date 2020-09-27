package br.com.houseparty.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor extends Usuario{

<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

=======
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

	
>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d
	
}
