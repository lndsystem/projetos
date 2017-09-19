package br.com.avlfocoimovel.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avlfocoimovel.domain.entity.Estado;
import br.com.avlfocoimovel.domain.repository.EstadoRepository;

@Service("estadoService")
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> pesquisarTodos() {
		return repository.findAll();
	}

}
