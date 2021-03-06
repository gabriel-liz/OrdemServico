package com.ordemServico.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Equipamento {
	
	@NotBlank
	@Column(name = "equipamento_tipo")
	private String tipo;
	
	@NotBlank
	@Column(name = "equipamento_marca")
	private String marca;
	
	@NotBlank
	@Column(name = "equipamento_descricao")
	private String descricao;
	
}
