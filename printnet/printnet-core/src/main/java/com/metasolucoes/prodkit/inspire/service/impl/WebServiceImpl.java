package com.metasolucoes.prodkit.inspire.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Ambiente;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.model.Status;
import com.metasolucoes.prodkit.inspire.repository.StatusRepository;
import com.metasolucoes.prodkit.inspire.service.WebService;

@Service
public class WebServiceImpl implements WebService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Processamento> getAllProcessamento() {

		List<Processamento> processamentos = new ArrayList<>();

		statusRepository.findAll().stream().forEach(status -> {

			Processamento p = new Processamento();
			p.setIdProcessamento(9999999l);
			p.setIdRequisicao(9999999l);
			p.setIdJob(9999999l);
			p.setIdLote(9999999l);
			p.setIdClienteGlobal(99999l);
			p.setIdSistemaGlobal(99999l);
			p.setAmbiente(Ambiente.HOMOLOGACAO);
			p.setIdentificacaoExterna("PORTO_SEGURO_GERACAO_PDF.wfd");
			p.setDataCadastro(LocalDateTime.now());
			p.setStatus(status);

			processamentos.add(p);
		});

		return processamentos;
	}

}
