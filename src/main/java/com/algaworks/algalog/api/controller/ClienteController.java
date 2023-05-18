package com.algaworks.algalog.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
