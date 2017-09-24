package br.com.avlfocoimovel.domain.service;

import java.util.List;

import br.com.avlfocoimovel.domain.entity.Cidade;

public interface CidadeService {

	public Cidade salvar(Cidade cidade);

	public void remover(Cidade cidade);

	public void remover(Long codigo);

	public List<Cidade> pesquisarTodos();

	public Cidade pesquisar(Cidade cidade);

	public Cidade pesquisar(Long codigo);
	
	public Cidade pesquisarPorNome(String nome);
}
