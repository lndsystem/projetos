package br.com.avlfocoimovel.domain.filters;

import br.com.avlfocoimovel.domain.entity.Estado;

public class CidadeFilter {

	private Estado estado;
	private String nomeCidade;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

}
