package br.com.avlfocoimovel.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Cidade;
import br.com.avlfocoimovel.domain.repository.CidadeRepository;
import br.com.avlfocoimovel.domain.service.CidadeService;
import br.com.avlfocoimovel.exception.CidadeJaCadastradaException;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Override
	public Cidade salvar(Cidade cidade) {
		Optional<Cidade> optional = repository.findByNomeIgnoreCase(cidade.getNome());
		if (optional.isPresent() == true) {
			throw new CidadeJaCadastradaException(String.format("Cidade [%s] já cadastrada", cidade.getNome()));
		}
		return repository.save(cidade);
	}

	@Override
	public void remover(Cidade cidade) {
		repository.delete(cidade);
	}

	@Override
	public void remover(Long codigo) {
		repository.delete(codigo);
	}

	@Override
	public List<Cidade> pesquisarTodos() {
		return repository.findAll();
	}

	@Override
	public Cidade pesquisar(Cidade cidade) {
		return pesquisar(cidade.getCodigo());
	}

	@Override
	public Cidade pesquisar(Long codigo) {
		return repository.findOne(codigo);
	}

	@Override
	public Cidade pesquisarPorNome(String nome) {
		Optional<Cidade> cidade = repository.findByNomeIgnoreCase(nome);
		return cidade.get();
	}

}
