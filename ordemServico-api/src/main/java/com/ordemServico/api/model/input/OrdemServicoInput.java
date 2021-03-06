package com.ordemServico.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemServicoInput {
	
	@Valid
	@NotNull
	private ClienteIdInput cliente;
	
	@Valid
	@NotNull
	private ResponsavelInput responsavel;
	
	@Valid
	@NotNull
	private Equipamentoinput equipamento;		
}
