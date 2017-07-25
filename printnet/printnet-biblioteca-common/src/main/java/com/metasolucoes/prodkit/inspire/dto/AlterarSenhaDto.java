package com.metasolucoes.prodkit.inspire.dto;

import org.hibernate.validator.constraints.NotBlank;

public class AlterarSenhaDto {

	private String senhaAtual;

	@NotBlank(message = "Senha \"Nova Senha\" é obrigatória")
	private String novaSenha;

	@NotBlank(message = "Senha \"Confirmação de Senha\" é obrigatória")
	private String confirmacaoSenha;

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
}
