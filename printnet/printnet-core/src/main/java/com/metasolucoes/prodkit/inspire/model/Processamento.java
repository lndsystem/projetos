package com.metasolucoes.prodkit.inspire.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "processamento", schema = "dbo", catalog = "prodkit_inspire")
public class Processamento implements Serializable {

	private static final long serialVersionUID = 7215072748909933298L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_processamento")
	private Long idProcessamento;

	@NotNull
	@Column(name = "id_requisicao")
	private Long idRequisicao;

	@Column(name = "id_job")
	private Long idJob;

	@Column(name = "id_lote")
	private Long idLote;

	@Column(name = "id_cliente_global")
	private Long idClienteGlobal;

	@Column(name = "id_sistema_global")
	private Long idSistemaGlobal;

	@Column(name = "id_produto_pk")
	private Long idProdutoPk;

	@Column(name = "id_produto_sub_pk")
	private Long idProdutoSubPk;

	@OneToOne
	@JoinColumn(name = "id_status", nullable = false)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Ambiente ambiente;

	@Column(name = "identificacao_externa")
	private String identificacaoExterna;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_execucao")
	private TipoExecucao tipoExecucao;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;

	public Long getIdProcessamento() {
		return idProcessamento;
	}

	public void setIdProcessamento(Long idProcessamento) {
		this.idProcessamento = idProcessamento;
	}

	public Long getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(Long idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

	public Long getIdLote() {
		return idLote;
	}

	public void setIdLote(Long idLote) {
		this.idLote = idLote;
	}

	public Long getIdClienteGlobal() {
		return idClienteGlobal;
	}

	public void setIdClienteGlobal(Long idClienteGlobal) {
		this.idClienteGlobal = idClienteGlobal;
	}

	public Long getIdSistemaGlobal() {
		return idSistemaGlobal;
	}

	public void setIdSistemaGlobal(Long idSistemaGlobal) {
		this.idSistemaGlobal = idSistemaGlobal;
	}

	public Long getIdProdutoPk() {
		return idProdutoPk;
	}

	public void setIdProdutoPk(Long idProdutoPk) {
		this.idProdutoPk = idProdutoPk;
	}

	public Long getIdProdutoSubPk() {
		return idProdutoSubPk;
	}

	public void setIdProdutoSubPk(Long idProdutoSubPk) {
		this.idProdutoSubPk = idProdutoSubPk;
	}

	public TipoExecucao getTipoExecucao() {
		return tipoExecucao;
	}

	public void setTipoExecucao(TipoExecucao tipoExecucao) {
		this.tipoExecucao = tipoExecucao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getIdentificacaoExterna() {
		return identificacaoExterna;
	}

	public void setIdentificacaoExterna(String identificacaoExterna) {
		this.identificacaoExterna = identificacaoExterna;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProcessamento == null) ? 0 : idProcessamento.hashCode());
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
		Processamento other = (Processamento) obj;
		if (idProcessamento == null) {
			if (other.idProcessamento != null)
				return false;
		} else if (!idProcessamento.equals(other.idProcessamento))
			return false;
		return true;
	}
}
