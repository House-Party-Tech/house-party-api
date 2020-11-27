package br.com.houseparty.api.model.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ENDERECO", nullable = false) 
	private long id_endereco;
	
	@Column(name="CEP", nullable = false)
	private String cep;
	@Column(name="CIDADE", nullable = false)
	private String cidade;
	@Column(name="PAIS", nullable = false)
	private String pais;
	@Column(name="LOGRADOURO", nullable = false)
	private String logradouro;
	@Column(name="BAIRRO", nullable = false)
	private String bairro;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String cidade, String pais, String bairro, String cep) {
		this.setLogradouro(logradouro);
		this.setCidade(cidade);
		this.setPais(pais);
		this.setBairro(bairro);
		this.setCep(cep);
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
