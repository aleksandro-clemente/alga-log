package com.algaworks.algalog.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.dto.OcorrenciaDTO;

@Service
public class RegistroOcorrenciaService {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public OcorrenciaDTO registrar(Long entregaId,String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return new OcorrenciaDTO(entrega.adicionarOcorrencia(descricao));
	}
	
	
}
