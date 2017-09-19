package br.com.avlfocoimovel.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Parametro;
import br.com.avlfocoimovel.domain.repository.ParametroRepository;
import br.com.avlfocoimovel.domain.service.ParametroService;

@Service
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParametroRepository repository;

	@Override
	public Parametro pesquisarPorChave(String chave) {
		return repository.findByChaveIgnoreCase(chave);
	}
}
