package br.com.avlfocoimovel.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Imovel;
import br.com.avlfocoimovel.domain.repository.ImovelRepository;
import br.com.avlfocoimovel.domain.service.ImovelService;

@Service
public class ImovelServiceImpl implements ImovelService {

	@Autowired
	private ImovelRepository repository;

	@Override
	public Imovel salvar(Imovel imovel) {
		return repository.save(imovel);
	}

	@Override
	public Imovel pesquisarPorCodigo(Long codigo) {
		return repository.findOne(codigo);
	}

	@Override
	public List<Imovel> pesquisarTodos() {
		return repository.findAllByAtivoTrue();
	}

	@Override
	public List<Imovel> pesquisarTodosDestaques() {
		return repository.findAllByAtivoTrueAndDestaqueTrue();
	}

	@Override
	public List<Imovel> pesquisarTodasOfertas() {
		return repository.findAllByAtivoTrueAndOfertaTrue();
	}

}
