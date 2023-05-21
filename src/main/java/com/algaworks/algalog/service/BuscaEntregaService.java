package com.algaworks.algalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;

@Service
public class BuscaEntregaService {
	@Autowired
	private EntregaRepository entregaRepository;
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe entrega de id "+entregaId));
	}
}
