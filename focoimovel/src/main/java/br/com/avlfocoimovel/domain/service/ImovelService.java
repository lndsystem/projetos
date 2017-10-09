package br.com.avlfocoimovel.domain.service;

import java.util.List;

import br.com.avlfocoimovel.domain.entity.Imovel;

public interface ImovelService {

	public Imovel salvar(Imovel imovel);

	public Imovel pesquisarPorCodigo(Long codigo);

	public List<Imovel> pesquisarTodos();

	public List<Imovel> pesquisarTodosDestaques();

	public List<Imovel> pesquisarTodasOfertas();

}
