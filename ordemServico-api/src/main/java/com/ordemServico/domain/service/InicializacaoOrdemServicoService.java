package com.ordemServico.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.repository.OrdemServicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InicializacaoOrdemServicoService {

	private OrdemServicoRepository ordemSevicoRepository;
	private BuscaOrdemServicoService buscaOrdemServicoService;
	
	@Transactional
	public void iniciar(Long ordemservico_id) {
		OrdemServico ordemServico = buscaOrdemServicoService.buscar(ordemservico_id);	
		
		ordemServico.iniciar();
		
		ordemSevicoRepository.save(ordemServico);
	}
}
