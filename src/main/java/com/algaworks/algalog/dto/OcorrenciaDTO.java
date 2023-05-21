package com.algaworks.algalog.dto;

import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.Ocorrencia;

public class OcorrenciaDTO {
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
	public OcorrenciaDTO() {
		
	}
		
	public OcorrenciaDTO(Long id, String descricao, OffsetDateTime dataRegistro) {
		this.id = id;
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
	}
	public OcorrenciaDTO(Ocorrencia entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.dataRegistro = entity.getDataRegistro();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
}
