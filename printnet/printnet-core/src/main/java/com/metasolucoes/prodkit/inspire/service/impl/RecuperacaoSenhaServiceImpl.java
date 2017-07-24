package com.metasolucoes.prodkit.inspire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.RecuperacaoSenha;
import com.metasolucoes.prodkit.inspire.repository.RecuperacaoSenhaRepository;
import com.metasolucoes.prodkit.inspire.service.RecuperacaoSenhaService;

@Service
public class RecuperacaoSenhaServiceImpl implements RecuperacaoSenhaService {

	@Autowired
	private RecuperacaoSenhaRepository repository;

	@Override
	public RecuperacaoSenha salvar(RecuperacaoSenha recuperacaoSenha) {
		return repository.save(recuperacaoSenha);
	}
}