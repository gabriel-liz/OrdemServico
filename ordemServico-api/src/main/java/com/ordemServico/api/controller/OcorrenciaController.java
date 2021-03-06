package com.ordemServico.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ordemServico.api.assembler.OcorrenciaAssembler;
import com.ordemServico.api.model.OcorrenciaModel;
import com.ordemServico.api.model.input.OcorrenciaInput;
import com.ordemServico.domain.model.Ocorrencia;
import com.ordemServico.domain.model.OrdemServico;
import com.ordemServico.domain.service.BuscaOrdemServicoService;
import com.ordemServico.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ordemservico/{ordemservico_id}/ocorrencias")
public class OcorrenciaController {
	
	private BuscaOrdemServicoService buscarOdemServicoService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long ordemservico_id,
			 @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada =  registroOcorrenciaService.registrar(ordemservico_id, ocorrenciaInput.getDescricao());
		
		return  ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long ordemservico_id){
		
		OrdemServico ordemServico = buscarOdemServicoService.buscar(ordemservico_id);
		
		return ocorrenciaAssembler.toCollectionModel(ordemServico.getOcorrencias());
	}

}
