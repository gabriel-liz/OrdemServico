package com.ordemServico.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ordemServico.domain.exception.NegocioException;

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
	
	@OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();	
	
	@Enumerated(EnumType.STRING)
	private StatusOrdem status;
	
	private String descricao_solucao;
		
	private OffsetDateTime data_inicio;	
	
	private OffsetDateTime data_fim;

	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setDataRegistro(OffsetDateTime.now());
		ocorrencia.setOrdemServico(this);
		
		this.getOcorrencias().add(ocorrencia);
		
		return ocorrencia;
		
	}

	public void finalizar() {
		
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("Ordem de Serviço não pode ser finalizada");
		}
		
		setStatus(StatusOrdem.FINALIZADA);
		setData_fim(OffsetDateTime.now());		
	}
	
	public boolean podeSerFinalizada() {
		return StatusOrdem.PENDENTE.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}

	public void iniciar() {
		
		if(naoPodeSerIniciada()) {
			throw new NegocioException("Ordem de Serviço não pode ser iniciada");
		}
		setStatus(StatusOrdem.EM_ANDAMENTO);
		setData_fim(OffsetDateTime.now());			
	}
	
	public boolean podeSerIniciada() {
		return StatusOrdem.PENDENTE.equals(getStatus());
	}
	public boolean naoPodeSerIniciada() {
		return !podeSerIniciada();
	}
}
