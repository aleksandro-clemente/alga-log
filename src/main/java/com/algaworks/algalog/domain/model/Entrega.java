package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.ValidationGroups;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaExceptionBadRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@Valid
	@ConvertGroup(from=Default.class,to=ValidationGroups.ClienteId.class)
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	private BigDecimal taxa;
	 
	@Enumerated(EnumType.STRING)
	@JsonProperty(access=Access.READ_ONLY)
	private StatusEntrega status;
	
	@JsonProperty(access=Access.READ_ONLY)
	private LocalDateTime dataPedido;
	@JsonProperty(access=Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;
	
	@OneToMany(mappedBy="entrega",cascade=CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	public Entrega() {
		
	}

	public Entrega(Long id, Cliente cliente, Destinatario destinatario, BigDecimal taxa, StatusEntrega status,
			LocalDateTime dataPedido, LocalDateTime dataFinalizacao) {
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataFinalizacao = dataFinalizacao;
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

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(id, other.id);
	}

	public Ocorrencia adicionarOcorrencia(String descricao) {
		 Ocorrencia ocorrencia = new Ocorrencia();
		 ocorrencia.setDescricao(descricao);
		 ocorrencia.setDataRegistro(OffsetDateTime.now());
		 ocorrencia.setEntrega(this);
		 
		 this.getOcorrencias().add(ocorrencia);
		 return ocorrencia;
	}

	public void finalizar() {
		if(!StatusEntrega.PENDENTE.equals(getStatus())) {
			throw new EntidadeNaoEncontradaExceptionBadRequest("Entrega nao pode ser finalizada");
		}
		setStatus(StatusEntrega.FINALIZADA);
		setDataFinalizacao(LocalDateTime.now());
		
	}
	
	
}
