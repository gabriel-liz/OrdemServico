package com.ordemServico.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.model.Cliente;
import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.model.Responsavel;
import com.ordemServico.domain.model.StatusOrdem;
import com.ordemServico.domain.repository.OrdemServicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdemServicoService {

	
	private OrdemServicoRepository ordemServicoRepository;
	//private ClienteRepository clienteRepository;
	private ClienteService clienteService;
	private ResponsavelService responsavelService;
	
	@Transactional
	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteService.buscar(ordemServico.getCliente().getId());
		
		Responsavel responsavel = responsavelService.buscar(ordemServico.getResponsavel().getId());
		
		ordemServico.setResponsavel(responsavel);
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdem.PENDENTE);
		ordemServico.setData_inicio(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}		
}
