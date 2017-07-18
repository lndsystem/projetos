package com.metasolucoes.prodkit.inspire.service;

import java.util.List;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.model.Processamento;

public interface WebService {
	public List<Processamento> getAllProcessamento();
	
	public List<Parametro> getParametroByIdProcessamento(Long idProcessamento);
}
