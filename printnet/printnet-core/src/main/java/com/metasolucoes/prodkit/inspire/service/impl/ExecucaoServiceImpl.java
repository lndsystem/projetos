package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Execucao;
import com.metasolucoes.prodkit.inspire.repository.ExecucaoRepository;
import com.metasolucoes.prodkit.inspire.service.ExecucaoService;

@Service("execucaoServiceImp")
public class ExecucaoServiceImpl implements ExecucaoService {

	@Autowired
	private ExecucaoRepository repository;

	@Override
	public List<Execucao> findByIdProcessamento(Long idProcessamento) {
		return repository.findExecucaoByProcessamentoIdProcessamento(idProcessamento);
	}
}
