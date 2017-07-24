package com.metasolucoes.prodkit.inspire.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotBlank;

public class RecuperarSenhaDto {
	@NotBlank(message = "E-mail é obrigatório!")
	private String email;
	private String novaSenha;
	private LocalDateTime dataSolicitacao;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
}