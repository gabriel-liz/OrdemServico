package com.ordemServico.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ordemServico.api.model.OrdemServicoModel;
import com.ordemServico.api.model.input.OrdemServicoInput;
import com.ordemServico.domain.model.OrdemServico;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class OrdemServicoAssembler {
	
	private ModelMapper modelMapper;
	
	public OrdemServicoModel toModel(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}
	
	public List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordemServico){
		return ordemServico.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return modelMapper.map(ordemServicoInput, OrdemServico.class);
	}

}
