package com.metasolucoes.prodkit.inspire.dto;

import org.hibernate.validator.constraints.NotBlank;

public class AlterarSenhaDto {

	@NotBlank
	private String senhaAtual;

	@NotBlank
	private String novaSenha;

	@NotBlank
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
