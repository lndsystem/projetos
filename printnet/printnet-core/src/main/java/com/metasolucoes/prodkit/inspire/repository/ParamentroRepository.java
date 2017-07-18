package com.metasolucoes.prodkit.inspire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metasolucoes.prodkit.inspire.model.Parametro;

@Repository
public interface ParamentroRepository extends JpaRepository<Parametro, Long> {
	public List<Parametro> findParametroByProcessamentoIdProcessamento(Long idProcessamento);
}
