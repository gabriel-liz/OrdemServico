package com.ordemServico.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.model.StatusOrdem;
import com.ordemServico.domain.repository.OrdemServicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdemServicoService {

	private OrdemServicoRepository ordemServicoRepository;
	
	
	@Transactional
	public OrdemServico criar(OrdemServico ordemServico) {
		
		
		
		ordemServico.setStatus(StatusOrdem.PENDENTE);
		ordemServico.setData_inicio(LocalDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	
}
