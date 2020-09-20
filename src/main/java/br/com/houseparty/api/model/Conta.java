package br.com.houseparty.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Conta {

	@Id
	@GeneratedValue
	private long id_conta;
	private String agencia;
	private String numero;
	private String tipo;
}
