package br.com.avlfocoimovel.domain.service;

import br.com.avlfocoimovel.domain.entity.Imovel;

public interface ImovelService {

	public Imovel salvar(Imovel imovel);
	
	public Imovel pesquisarPorCodigo(Long codigo);
}
