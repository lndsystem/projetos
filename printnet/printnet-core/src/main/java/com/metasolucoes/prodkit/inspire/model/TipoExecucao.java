package com.metasolucoes.prodkit.inspire.model;

public enum TipoExecucao {
	PRINTNET("PrintNet", "ImplementacaoImpl");

	private final String descricao;
	private final String implementacao;

	TipoExecucao(final String descricao, final String implementacao) {
		this.descricao = descricao;
		this.implementacao = implementacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getImplementacao() {
		return implementacao;
	}

	public static TipoExecucao getTipoExecucao(String tipoExecucao) {
		return TipoExecucao.valueOf(tipoExecucao);
	}
}