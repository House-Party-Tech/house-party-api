package br.com.houseparty.api.model;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private long nf;
	private Fornecedor id_fornecedor;
	private Cliente id_cliente;
	private Entregador id_entregador;
	private int qtd_produto;
	private long id_pedido;
	private Calendar dt_compra;
	private String tipo_entrega;

}
