package com.ordemServico.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.model.Ocorrencia;
import com.ordemServico.domain.model.OrdemServico;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaOrdemServicoService buscaOrdemServicoService;
	
	@Transactional
	public Ocorrencia registrar(Long ordem_servico_id, String descricao) {
		OrdemServico ordemServico = buscaOrdemServicoService.buscar(ordem_servico_id);
		
		return ordemServico.adicionarOcorrencia(descricao);
	}

}
