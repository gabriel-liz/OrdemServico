package com.ordemServico.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelInput {
	
	@NotNull
	private Long id;

}
