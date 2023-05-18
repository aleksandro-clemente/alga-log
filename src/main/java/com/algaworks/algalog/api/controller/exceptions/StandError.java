package com.algaworks.algalog.api.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandError implements Serializable{
	private static final long serialVersionUID = 1L;
	private Instant timeStamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String path;
	

	public Instant getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
