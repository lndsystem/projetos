package br.com.avlfocoimovel.domain.service;

import java.util.List;

import br.com.avlfocoimovel.domain.entity.Diferenciais;

public interface DiferenciaisService {

	public List<List<Diferenciais>> pesquisarTodosPorColuna();
	
	public List<Diferenciais> pesquisarTodos();
}
