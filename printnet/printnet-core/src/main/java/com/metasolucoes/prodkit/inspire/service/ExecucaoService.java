package com.metasolucoes.prodkit.inspire.service;

import java.util.List;

import com.metasolucoes.prodkit.inspire.model.Execucao;

public interface ExecucaoService {

	public List<Execucao> findByIdProcessamento(Long idProcessamento);
}
