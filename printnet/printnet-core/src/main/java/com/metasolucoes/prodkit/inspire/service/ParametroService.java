package com.metasolucoes.prodkit.inspire.service;

import java.util.List;

import com.metasolucoes.prodkit.inspire.model.Parametro;

public interface ParametroService {

	public List<Parametro> getParametroByIdProcessamento(Long idProcessamento);
}
