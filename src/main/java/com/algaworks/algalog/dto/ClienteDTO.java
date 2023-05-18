package com.algaworks.algalog.dto;

import java.io.Serializable;

import com.algaworks.algalog.domain.model.Cliente;
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String fone;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Long id, String nome, String email, String fone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.fone = entity.getFone();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setTelefone(String fone) {
		this.fone = fone;
	}
	
	
}
