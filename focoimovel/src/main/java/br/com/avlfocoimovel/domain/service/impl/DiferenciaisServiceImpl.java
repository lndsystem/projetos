package br.com.avlfocoimovel.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Diferenciais;
import br.com.avlfocoimovel.domain.repository.DiferenciaisRepository;
import br.com.avlfocoimovel.domain.service.DiferenciaisService;

@Service
public class DiferenciaisServiceImpl implements DiferenciaisService {

	@Autowired
	private DiferenciaisRepository repository;

	@Override
	public List<List<Diferenciais>> pesquisarTodosPorColuna() {
		List<Diferenciais> diferenciais = repository.findAll();

		List<List<Diferenciais>> retorno = new ArrayList<>();
		List<Diferenciais> lista = new ArrayList<>();
		for (int i = 0; i < diferenciais.size(); i++) {
			if (i > 0 && i % 4 == 0) {
				retorno.add(lista);
				lista = new ArrayList<>();
			}
			lista.add(diferenciais.get(i));
		}
		if (lista.isEmpty() == false) {
			retorno.add(lista);
		}
		return retorno;
	}

	@Override
	public List<Diferenciais> pesquisarTodos() {
		return repository.findAll();
	}

}
