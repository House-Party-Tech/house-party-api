package br.com.houseparty.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="entregador")
public class Entregador extends Usuario{

<<<<<<< HEAD
=======
	@Column(name="CPF")
	private String cpf;
>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public Entregador() {}

=======
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d
	
	
}
