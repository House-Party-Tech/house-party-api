package br.com.houseparty.api.excecoes;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<Object> handleAnyException (Exception e, WebRequest request){
		String descricaoErro = e.getLocalizedMessage();
		if(descricaoErro == null)
			descricaoErro = e.toString();
		
		MensagemErro mensagemErro = new MensagemErro(new Date(), descricaoErro);
		return new ResponseEntity<>(mensagemErro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
