package com.ordemServico.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ordemServico.api.assembler.OrdemServicoAssembler;
import com.ordemServico.api.model.OrdemServicoModel;
import com.ordemServico.api.model.input.OrdemServicoInput;
import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.repository.OrdemServicoRepository;
import com.ordemServico.domain.service.FinalizacaoOrdemServicoService;
import com.ordemServico.domain.service.InicializacaoOrdemServicoService;
import com.ordemServico.domain.service.OrdemServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {
	
	
	private OrdemServicoRepository ordemServicoRepository;
	private OrdemServicoService ordemServicoService;
	private FinalizacaoOrdemServicoService finalizacaoEntFinalizacaoOrdemServicoService;
	private InicializacaoOrdemServicoService inicializacaoOrdemServicoService;
	private OrdemServicoAssembler ordemServicoAssembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) {
		
		OrdemServico novaOrdemServico = ordemServicoAssembler.toEntity(ordemServicoInput);
		
		OrdemServico ordemServicoSolicitada = ordemServicoService.criar(novaOrdemServico);
		return ordemServicoAssembler.toModel(ordemServicoSolicitada);
	}
	
	@PutMapping("/{ordemServicoId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemServicoId) {
		finalizacaoEntFinalizacaoOrdemServicoService.finalizar(ordemServicoId);
	}
	
	@PutMapping("/{ordemServicoId}/inicializacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void iniciar(@PathVariable Long ordemServicoId) {
		inicializacaoOrdemServicoService.iniciar(ordemServicoId);
	}
	
	
	@GetMapping
	public List<OrdemServicoModel> listar(){
		return ordemServicoAssembler.toCollectionModel(ordemServicoRepository.findAll());
	}
	
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId){
		return ordemServicoRepository.findById(ordemServicoId)
				.map(ordemServico -> ResponseEntity.ok(ordemServicoAssembler.toModel(ordemServico)))
				.orElse(ResponseEntity.notFound().build());				
	}

}
