package com.algaworks.algalog.api.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaExceptionBadRequest;

import ch.qos.logback.core.status.Status;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<StandError> recursoNaoEncontrado(EntidadeNaoEncontradaException e,
			HttpServletRequest request) {
		StandError err = new StandError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setErro("Recurso não Encontrado");
		err.setMensagem(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ExceptionHandler(EntidadeNaoEncontradaExceptionBadRequest.class)
	public ResponseEntity<StandError> recursoNaoEncontrado(EntidadeNaoEncontradaExceptionBadRequest e,
			HttpServletRequest request) {
		StandError err = new StandError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setErro("Recurso não Encontrado");
		err.setMensagem(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandError> validacao(ConstraintViolationException e, HttpServletRequest request) {
		StandError err = new StandError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setErro("Erro de Validação");
		err.setMensagem(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
		
	}
}
