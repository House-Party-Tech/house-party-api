package br.com.houseparty.api.excecoes;

import java.util.Date;

public class MensagemErro {

	private Date currentDate;
	private String message;
	
	public MensagemErro() {}
	
	public MensagemErro(Date dataAtual, String mensagem) {
		this.currentDate = dataAtual;
		this.message = mensagem;
	}
	
	public Date getDataAtual() {
		return currentDate;
	}
	public void setDataAtual(Date dataAtual) {
		this.currentDate = dataAtual;
	}
	public String getMensagem() {
		return message;
	}
	public void setMensagem(String mensagem) {
		this.message = mensagem;
	}
	
	
}
