package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Ambiente;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.model.Status;
import com.metasolucoes.prodkit.inspire.service.WebService;

@Service
public class WebServiceImpl implements WebService {

	@Override
	public List<Processamento> getAllProcessamento() {
		
		List<Processamento> processamentos = new ArrayList<>();
		
		Processamento p = new Processamento();
		p.setAmbiente(Ambiente.HOMOLOGACAO);
		p.setStatus(new Status(1l));
		p.setIdClienteGlobal(20l);
		p.setIdSistemaGlobal(30l);
		p.setIdRequisicao(50l);
		
		processamentos.add(p);
		
		return processamentos;
	}

}
