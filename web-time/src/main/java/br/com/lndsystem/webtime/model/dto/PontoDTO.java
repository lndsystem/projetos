package br.com.lndsystem.webtime.model.dto;

import java.time.LocalDateTime;

public class PontoDTO {
	
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private String observacao;
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFim() {
		return fim;
	}
	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
