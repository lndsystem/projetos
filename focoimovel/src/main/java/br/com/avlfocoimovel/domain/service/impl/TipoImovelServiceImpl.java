package br.com.avlfocoimovel.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.TipoImovel;
import br.com.avlfocoimovel.domain.repository.TipoImovelRepository;
import br.com.avlfocoimovel.domain.service.TipoImovelService;

@Service
public class TipoImovelServiceImpl implements TipoImovelService {

	@Autowired
	private TipoImovelRepository repository;

	@Override
	public TipoImovel pesquisarPorCodigo(Long codigo) {
		return repository.findOne(codigo);
	}

	@Override
	public List<TipoImovel> pesquisarTodos() {
		return repository.findAll();
	}

	@Override
	public TipoImovel salvar(TipoImovel tipoImovel) {
		return repository.save(tipoImovel);
	}

	@Override
	public List<TipoImovel> salvar(List<TipoImovel> tipoImoveis) {
		return repository.save(tipoImoveis);
	}

	@Override
	public void remover(Long codigo) {
		repository.delete(codigo);
	}

}
