package com.metasolucoes.prodkit.inspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.repository.helper.queries.ProcessamentoQueries;

public interface ProcessamentoRepository extends JpaRepository<Processamento, Long>, ProcessamentoQueries {

}
