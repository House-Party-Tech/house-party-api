package br.com.houseparty.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Cliente extends Usuario{

<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

=======
	@Column(name="CPF")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="ENDERECO_ID_ENDERECO")
	private Endereco endereco;
	
>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d
	public Cliente() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
