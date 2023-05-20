package com.algaworks.algalog.api.controller;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algalog.dto.ClienteDTO;
import com.algaworks.algalog.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listar(){
		List<ClienteDTO>dto = clienteService.listar();
		return ResponseEntity.ok().body(dto);
	}
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable Long clienteId){
		ClienteDTO dto = clienteService.buscar(clienteId);
		return ResponseEntity.ok().body(dto);
	}
	@PostMapping
	public ResponseEntity<ClienteDTO> adicionar(@Valid @RequestBody ClienteDTO dto){
		 dto = clienteService.adicionar(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		 return ResponseEntity.created(uri).body(dto);	 
	}
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@Valid @PathVariable Long clienteId,@RequestBody ClienteDTO dto){
		dto = clienteService.atualizar(clienteId, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId){
		clienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
