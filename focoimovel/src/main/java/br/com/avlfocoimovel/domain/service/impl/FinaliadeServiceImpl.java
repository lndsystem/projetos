package br.com.avlfocoimovel.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Finalidade;
import br.com.avlfocoimovel.domain.repository.FinalidadeRepository;
import br.com.avlfocoimovel.domain.service.FinalidadeService;

@Service
public class FinaliadeServiceImpl implements FinalidadeService {

	@Autowired
	private FinalidadeRepository repository;

	@Override
	public Finalidade salvar(Finalidade finalidade) {
		return repository.save(finalidade);
	}

	@Override
	public List<Finalidade> pesquisarTodos() {
		return repository.findAll();
	}
}
