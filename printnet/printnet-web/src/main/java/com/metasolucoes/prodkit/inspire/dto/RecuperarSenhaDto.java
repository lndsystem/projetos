package com.metasolucoes.prodkit.inspire.dto;

import org.hibernate.validator.constraints.NotBlank;

public class RecuperarSenhaDto {

	@NotBlank(message = "E-mail é obrigatório!")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
