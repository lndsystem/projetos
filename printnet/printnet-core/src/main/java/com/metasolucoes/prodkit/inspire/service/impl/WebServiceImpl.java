package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.repository.ProcessamentoRepository;
import com.metasolucoes.prodkit.inspire.repository.StatusRepository;
import com.metasolucoes.prodkit.inspire.service.WebService;

@Service
public class WebServiceImpl implements WebService {

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private ProcessamentoRepository processamentoRepository;

	@Override
	public List<Processamento> getAllProcessamento() {
		return processamentoRepository.findAll();
	}

}
