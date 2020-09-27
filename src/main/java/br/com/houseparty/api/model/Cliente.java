package br.com.houseparty.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Usuario{

	@Column(name="CPF")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="ENDERECO_ID_ENDERECO")
	private Endereco endereco;
	
	public Cliente() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
