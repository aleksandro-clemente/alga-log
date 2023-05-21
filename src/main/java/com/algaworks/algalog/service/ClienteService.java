package com.algaworks.algalog.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.dto.ClienteDTO;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.exceptions.EntidadeNaoEncontradaException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public List<ClienteDTO> listar() {
		List<Cliente> cliente = clienteRepository.findAll();
		List<ClienteDTO> dto = cliente.stream().map((x) -> new ClienteDTO(x)).collect(Collectors.toList());
		return dto;
	}
	@Transactional(readOnly = true)
	public ClienteDTO buscar(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Recurso nao encontrado"));
		return new ClienteDTO(cliente);
	}
	@Transactional
	public ClienteDTO adicionar(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		copiarDtoParaCliente(cliente, dto);
		clienteRepository.save(cliente);
		return new ClienteDTO(cliente);
	}
	@Transactional
	public ClienteDTO atualizar(Long clienteId,ClienteDTO dto) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Não existe cliente de id "+clienteId));
		copiarDtoParaCliente(cliente,dto);
		clienteRepository.save(cliente);
		return new ClienteDTO(cliente);
	}
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public void copiarDtoParaCliente(Cliente cliente,ClienteDTO dto) {
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setFone(dto.getFone());;
	}

}
