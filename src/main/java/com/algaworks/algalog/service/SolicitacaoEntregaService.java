package com.algaworks.algalog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaExceptionBadRequest;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		clienteRepository.findById(entrega.getCliente().getId())
			    .orElseThrow(() -> new EntidadeNaoEncontradaExceptionBadRequest("Não existe cliente de id "+entrega.getCliente().getId()));
		return entregaRepository.save(entrega);
	}
}
