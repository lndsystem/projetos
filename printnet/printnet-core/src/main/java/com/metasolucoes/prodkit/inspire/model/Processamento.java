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

import org.hibernate.validator.constraints.NotBlank;
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

	private String tabelas;

	@NotBlank
	@Column(name = "nome_arquivo_wfd")
	private String nomeArquivoWfd;

	@NotBlank
	@Column(name = "nome_engine")
	private String nomeEngine;

	@NotBlank
	@Column(name = "nome_output")
	private String nomeOutput;

	@NotBlank
	@Column(name = "nome_job")
	private String nomeJob;

	@NotBlank
	@Column(name = "mascara_saida")
	private String mascaraSaida;

	@Column(name = "caminho_saida")
	private String caminhoSaida;

	@Column(name = "arquivo_entrada_1")
	private String arquivoEntrada1;

	@Column(name = "arquivo_entrada_2")
	private String arquivoEntrada2;

	@Column(name = "arquivo_entrada_3")
	private String arquivoEntrada3;

	@Column(name = "arquivo_entrada_4")
	private String arquivoEntrada4;

	@Column(name = "arquivo_entrada_5")
	private String arquivoEntrada5;

	@Column(name = "arquivo_script_1")
	private String arquivoScript1;

	@Column(name = "arquivo_script_2")
	private String arquivoScript2;

	@Column(name = "arquivo_script_3")
	private String arquivoScript3;

	@Column(name = "arquivo_script_4")
	private String arquivoScript4;

	@Column(name = "arquivo_script_5")
	private String arquivoScript5;

	@OneToOne
	@JoinColumn(name = "id_status", nullable = false)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Ambiente ambiente;

	@Column(name = "identificacao_externa")
	private String identificacaoExterna;

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

	public String getTabelas() {
		return tabelas;
	}

	public void setTabelas(String tabelas) {
		this.tabelas = tabelas;
	}

	public String getNomeArquivoWfd() {
		return nomeArquivoWfd;
	}

	public void setNomeArquivoWfd(String nomeArquivoWfd) {
		this.nomeArquivoWfd = nomeArquivoWfd;
	}

	public String getNomeEngine() {
		return nomeEngine;
	}

	public void setNomeEngine(String nomeEngine) {
		this.nomeEngine = nomeEngine;
	}

	public String getNomeOutput() {
		return nomeOutput;
	}

	public void setNomeOutput(String nomeOutput) {
		this.nomeOutput = nomeOutput;
	}

	public String getNomeJob() {
		return nomeJob;
	}

	public void setNomeJob(String nomeJob) {
		this.nomeJob = nomeJob;
	}

	public String getMascaraSaida() {
		return mascaraSaida;
	}

	public void setMascaraSaida(String mascaraSaida) {
		this.mascaraSaida = mascaraSaida;
	}

	public String getCaminhoSaida() {
		return caminhoSaida;
	}

	public void setCaminhoSaida(String caminhoSaida) {
		this.caminhoSaida = caminhoSaida;
	}

	public String getArquivoEntrada1() {
		return arquivoEntrada1;
	}

	public void setArquivoEntrada1(String arquivoEntrada1) {
		this.arquivoEntrada1 = arquivoEntrada1;
	}

	public String getArquivoEntrada2() {
		return arquivoEntrada2;
	}

	public void setArquivoEntrada2(String arquivoEntrada2) {
		this.arquivoEntrada2 = arquivoEntrada2;
	}

	public String getArquivoEntrada3() {
		return arquivoEntrada3;
	}

	public void setArquivoEntrada3(String arquivoEntrada3) {
		this.arquivoEntrada3 = arquivoEntrada3;
	}

	public String getArquivoEntrada4() {
		return arquivoEntrada4;
	}

	public void setArquivoEntrada4(String arquivoEntrada4) {
		this.arquivoEntrada4 = arquivoEntrada4;
	}

	public String getArquivoEntrada5() {
		return arquivoEntrada5;
	}

	public void setArquivoEntrada5(String arquivoEntrada5) {
		this.arquivoEntrada5 = arquivoEntrada5;
	}

	public String getArquivoScript1() {
		return arquivoScript1;
	}

	public void setArquivoScript1(String arquivoScript1) {
		this.arquivoScript1 = arquivoScript1;
	}

	public String getArquivoScript2() {
		return arquivoScript2;
	}

	public void setArquivoScript2(String arquivoScript2) {
		this.arquivoScript2 = arquivoScript2;
	}

	public String getArquivoScript3() {
		return arquivoScript3;
	}

	public void setArquivoScript3(String arquivoScript3) {
		this.arquivoScript3 = arquivoScript3;
	}

	public String getArquivoScript4() {
		return arquivoScript4;
	}

	public void setArquivoScript4(String arquivoScript4) {
		this.arquivoScript4 = arquivoScript4;
	}

	public String getArquivoScript5() {
		return arquivoScript5;
	}

	public void setArquivoScript5(String arquivoScript5) {
		this.arquivoScript5 = arquivoScript5;
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
