package com.metasolucoes.prodkit.inspire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metasolucoes.prodkit.inspire.model.Execucao;

@Repository
public interface ExecucaoRepository extends JpaRepository<Execucao, Long> {

	public List<Execucao> findExecucaoByProcessamentoIdProcessamento(Long idProcessamento);
}
