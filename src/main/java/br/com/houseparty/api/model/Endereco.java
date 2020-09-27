package br.com.houseparty.api.model;

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
	@Column(name="ID_ENDERECO") 
	private long id_endereco;
	
	@Column(name="CEP")
	private String cep;
	@Column(name="CIDADE")
	private String cidade;
	@Column(name="PAIS")
	private String pais;
	@Column(name="RUA")
	private String rua;
	@Column(name="LOGRADOURO")
	private String logradouro;
	@Column(name="BAIRRO")
	private String bairro;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String cidade, String pais, String rua, String bairro, String cep) {
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.pais = pais;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
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
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
