package com.ordemServico.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ordemServico.domain.model.Responsavel;
import com.ordemServico.domain.repository.ResponsavelRepository;
import com.ordemServico.domain.service.ResponsavelService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;	
	private ResponsavelService responsavelService;
	
	@GetMapping
	public List<Responsavel> listar() {
		return responsavelRepository.findAll();
	}
	
	@GetMapping("/{responsavelId}")
	public ResponseEntity<Responsavel> buscar(@PathVariable Long responsavelId) {
		return responsavelRepository.findById(responsavelId)
				.map(responsavel -> ResponseEntity.ok(responsavel))
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Responsavel adicionarResponsavel(@Valid @RequestBody Responsavel responsavel) {
		return responsavelService.salvar(responsavel);
	}
	
	@PutMapping("/{responsavelId}")
	public ResponseEntity<Responsavel> atualizar(@PathVariable Long responsavelId,
			@Valid @RequestBody Responsavel responsavel){
		if(!responsavelRepository.existsById(responsavelId)) {
			return ResponseEntity.notFound().build();
		}
		
		responsavel.setId(responsavelId);		
		responsavel = responsavelService.salvar(responsavel);
		
		
		return ResponseEntity.ok(responsavel);
	}
	
	@DeleteMapping("/{responsavelId}")
	public ResponseEntity<Void> remover(@PathVariable Long responsavelId){
		if(!responsavelRepository.existsById(responsavelId)) {
			return ResponseEntity.notFound().build();
		}		
		responsavelService.excluir(responsavelId);
		
		return ResponseEntity.noContent().build();
	}
	
}
