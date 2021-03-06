package com.ordemServico.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ordemServico.domain.exception.NegocioException;
import com.ordemServico.domain.model.Responsavel;
import com.ordemServico.domain.repository.ResponsavelRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResponsavelService {

	private ResponsavelRepository responsavelRepository;
	
	public Responsavel buscar(Long responsavelId) {
		return responsavelRepository.findById(responsavelId)
				.orElseThrow(() -> new NegocioException("Responsavel não encontrado"));
	}
	
	
	@Transactional
	public Responsavel salvar(Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		responsavelRepository.deleteById(clienteId);
	}
}
