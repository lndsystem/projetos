package br.com.avlfocoimovel.domain.service;

import java.util.List;

import br.com.avlfocoimovel.domain.entity.TipoImovel;

public interface TipoImovelService {

	public TipoImovel pesquisarPorCodigo(Long codigo);

	public List<TipoImovel> pesquisarTodos();

	public TipoImovel salvar(TipoImovel tipoImovel);

	public List<TipoImovel> salvar(List<TipoImovel> tipoImoveis);

	public void remover(Long codigo);
}
