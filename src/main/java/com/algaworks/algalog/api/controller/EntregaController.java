package com.algaworks.algalog.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.dto.EntregaDTO;
import com.algaworks.algalog.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@PostMapping
	public ResponseEntity<EntregaDTO> solicitar(@Valid @RequestBody EntregaDTO dto) {
		dto = solicitacaoEntregaService.solicitar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto); 
	}
	
	@GetMapping
	public ResponseEntity<List<EntregaDTO>> listar(){
		List<EntregaDTO> dto = solicitacaoEntregaService.listar();
		return ResponseEntity.ok().body(dto);
	}
	@GetMapping(value="/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){
		EntregaDTO dto = solicitacaoEntregaService.buscar(entregaId);
		return ResponseEntity.ok().body(dto);
	}
}
