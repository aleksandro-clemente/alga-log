package com.algaworks.algalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.dto.ClienteDTO;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> listar() {
		List<Cliente> cliente = clienteRepository.findAll();
		List<ClienteDTO> dto = cliente.stream().map((x) -> new ClienteDTO(x)).collect(Collectors.toList());
		return dto;
	}
	
	public ClienteDTO buscar(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Recurso nao encontrado"));
		return new ClienteDTO(cliente);
	}
}
