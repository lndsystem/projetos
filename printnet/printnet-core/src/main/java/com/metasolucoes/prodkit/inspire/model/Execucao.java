package com.metasolucoes.prodkit.inspire.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "execucao", schema = "dbo", catalog = "prodkit_inspire")
public class Execucao implements Serializable {

	private static final long serialVersionUID = -450002064369718275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_execucao")
	private Long idExecucao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_processamento", nullable = false)
	private Processamento processamento;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "inicio_execucao")
	private LocalDateTime inicioExecucao;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "fim_execucao")
	private LocalDateTime fimExecucao;

	@OneToOne
	@JoinColumn(name = "id_status", nullable = false)
	private Status status;

	private String duracao;

	@Column(name = "quantidade_warning")
	private Long quantidadeWarning;

	@Column(name = "quantidade_sheets")
	private Long quantidadeSheets;

	public Long getIdExecucao() {
		return idExecucao;
	}

	public void setIdExecucao(Long idExecucao) {
		this.idExecucao = idExecucao;
	}

	public Processamento getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Processamento processamento) {
		this.processamento = processamento;
	}

	public LocalDateTime getInicioExecucao() {
		return inicioExecucao;
	}

	public void setInicioExecucao(LocalDateTime inicioExecucao) {
		this.inicioExecucao = inicioExecucao;
	}

	public LocalDateTime getFimExecucao() {
		return fimExecucao;
	}

	public void setFimExecucao(LocalDateTime fimExecucao) {
		this.fimExecucao = fimExecucao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Long getQuantidadeWarning() {
		return quantidadeWarning;
	}

	public void setQuantidadeWarning(Long quantidadeWarning) {
		this.quantidadeWarning = quantidadeWarning;
	}

	public Long getQuantidadeSheets() {
		return quantidadeSheets;
	}

	public void setQuantidadeSheets(Long quantidadeSheets) {
		this.quantidadeSheets = quantidadeSheets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExecucao == null) ? 0 : idExecucao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Execucao other = (Execucao) obj;
		if (idExecucao == null) {
			if (other.idExecucao != null)
				return false;
		} else if (!idExecucao.equals(other.idExecucao))
			return false;
		return true;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
