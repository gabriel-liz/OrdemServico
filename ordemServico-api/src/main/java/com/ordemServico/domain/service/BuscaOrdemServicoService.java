package com.ordemServico.domain.service;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.exception.EntidadeNaoEncontradaException;
import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.repository.OrdemServicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaOrdemServicoService {
	
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico buscar(Long ordem_servico_id) {
		
		return ordemServicoRepository.findById(ordem_servico_id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrada"));
	}

}
