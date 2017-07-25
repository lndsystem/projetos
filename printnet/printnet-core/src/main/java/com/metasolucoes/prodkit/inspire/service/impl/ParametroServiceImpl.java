package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.repository.ParamentroRepository;
import com.metasolucoes.prodkit.inspire.service.ParametroService;

@Service("parametroServiceImpl")
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParamentroRepository repository;

	@Override
	public List<Parametro> getParametroByIdProcessamento(Long idProcessamento) {
		return repository.findParametroByProcessamentoIdProcessamento(idProcessamento);
	}
}
