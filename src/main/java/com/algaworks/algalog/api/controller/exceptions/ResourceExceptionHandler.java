package com.algaworks.algalog.api.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;

import ch.qos.logback.core.status.Status;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<StandError> recursoNaoEncontrado(EntidadeNaoEncontradaException e,HttpServletRequest request){
		StandError err = new StandError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setErro("Recurso não Encontrado");
		err.setMensagem(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
