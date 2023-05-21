package com.algaworks.algalog.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.ValidationGroups;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Destinatario;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;

public class EntregaDTO {
	private Long id;
	@NotNull
	private Cliente cliente;
	@NotNull
	private Destinatario destinatario;	
	@NotNull
	private BigDecimal taxa;
	private StatusEntrega status;
	private LocalDateTime dataPedido;

	public EntregaDTO() {

	}

	public EntregaDTO(Long id, Cliente cliente, Destinatario destinatario, BigDecimal taxa, StatusEntrega status,
			LocalDateTime dataPedido) {
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.status = status;
		this.dataPedido = dataPedido;
	}

	public EntregaDTO(Entrega entity) {
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.destinatario = entity.getDestinatario();
		this.taxa = entity.getTaxa();
		this.status = entity.getStatus();
		this.dataPedido = entity.getDataPedido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

}
