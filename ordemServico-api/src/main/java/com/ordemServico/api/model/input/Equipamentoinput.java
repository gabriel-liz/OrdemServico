package com.ordemServico.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Equipamentoinput {

	
	@NotBlank	
	private String tipo;
	
	@NotBlank	
	private String marca;
	
	@NotBlank	
	private String descricao;
}
