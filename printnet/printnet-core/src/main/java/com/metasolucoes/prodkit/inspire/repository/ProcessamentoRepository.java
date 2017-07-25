package com.metasolucoes.prodkit.inspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.repository.helper.queries.ProcessamentoQueries;

@Repository
public interface ProcessamentoRepository extends JpaRepository<Processamento, Long>, ProcessamentoQueries {

}
