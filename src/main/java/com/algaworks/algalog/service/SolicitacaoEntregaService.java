package com.algaworks.algalog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.dto.EntregaDTO;
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
	public EntregaDTO solicitar(EntregaDTO dto) {
		Entrega entrega = new Entrega();
		copiarDtoParaEntity(entrega,dto);
		clienteRepository.findById(entrega.getCliente().getId())
			    .orElseThrow(() -> new EntidadeNaoEncontradaExceptionBadRequest("Não existe cliente de id "+entrega.getCliente().getId()));
		entregaRepository.save(entrega);
		return new EntregaDTO(entrega);
	}
	@Transactional(readOnly = true)
	public List<EntregaDTO> listar(){
		 List<Entrega> entregas = entregaRepository.findAll();
		 List<EntregaDTO> dto = entregas.stream().map((x) -> new EntregaDTO(x)).collect(Collectors.toList());
		 return dto;
	}
	@Transactional(readOnly = true)
	public EntregaDTO buscar(Long entregaId) {
		Entrega entrega = entregaRepository.findById(entregaId)
				.orElseThrow(()->new EntidadeNaoEncontradaException("Não existe entrega de id "+entregaId));
		return new EntregaDTO(entrega);
	}
	public void copiarDtoParaEntity(Entrega entity,EntregaDTO dto){
		entity.setStatus(StatusEntrega.PENDENTE);
		entity.setDataPedido(LocalDateTime.now());
		entity.setCliente(dto.getCliente());
		entity.setDestinatario(dto.getDestinatario());
		entity.setTaxa(dto.getTaxa());
	}
	
}
