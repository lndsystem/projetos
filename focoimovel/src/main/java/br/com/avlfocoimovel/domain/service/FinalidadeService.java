package br.com.avlfocoimovel.domain.service;

import java.util.List;

import br.com.avlfocoimovel.domain.entity.Finalidade;

public interface FinalidadeService {
	public Finalidade salvar(Finalidade finalidade);
	
	public List<Finalidade> pesquisarTodos();
}
