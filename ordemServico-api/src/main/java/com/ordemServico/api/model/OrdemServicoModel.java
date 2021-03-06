package com.ordemServico.api.model;

import java.time.OffsetDateTime;

import com.ordemServico.domain.model.StatusOrdem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemServicoModel {

	private Long id;
	//private String nomeCliente;	
	//private String nomeResponsavel;
	private ClienteResumoModel cliente;
	private ResponsavelResumoModel responsavel;
	private EquipamentoModel equipamento;
	private StatusOrdem status;
	private OffsetDateTime data_inicio;
	private OffsetDateTime data_fim;
}
