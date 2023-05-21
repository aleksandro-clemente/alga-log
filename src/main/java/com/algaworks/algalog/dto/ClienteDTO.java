package com.algaworks.algalog.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.algaworks.algalog.domain.model.Cliente;
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message="Campo Requerido")
	@Size(max=60)
	private String nome;
	@NotBlank(message="Campo Requerido")
	@Email(message="Digite um email válido")
	private String email;
	@NotBlank(message="Campo Requerido")
	@Size(max=20)
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
