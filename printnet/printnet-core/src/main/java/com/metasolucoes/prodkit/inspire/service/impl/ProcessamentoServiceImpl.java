package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.repository.ProcessamentoRepository;
import com.metasolucoes.prodkit.inspire.service.ProcessamentoService;

@Service("processamentoServiceImpl")
public class ProcessamentoServiceImpl implements ProcessamentoService {

	@Autowired
	private ProcessamentoRepository repository;

	@Override
	public List<Processamento> getAllProcessamento() {
		return repository.findAll();
	}
}
