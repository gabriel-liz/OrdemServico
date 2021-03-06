package com.ordemServico.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordemServico.domain.model.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	List<Responsavel> findByNome(String nome);	
}
