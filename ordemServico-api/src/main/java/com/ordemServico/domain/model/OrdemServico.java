package com.ordemServico.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrdemServico {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Responsavel responsavel;
	
	@Embedded
	private Equipamento equipamento;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdem status;
	
	private String descricao_solucao;
	
	private LocalDateTime data_inicio;
	
	private LocalDateTime data_fim;

}
