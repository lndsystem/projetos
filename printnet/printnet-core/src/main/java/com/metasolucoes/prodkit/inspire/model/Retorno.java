package com.metasolucoes.prodkit.inspire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "retorno", schema = "dbo", catalog = "prodkit_inspire")
public class Retorno implements Serializable {

	private static final long serialVersionUID = 647922338717588175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_retorno")
	private Long idRetorno;

	@Column(name = "caminho_share")
	private String caminhoShare;

	@Column(name = "usuario_share")
	private String usuarioShare;

	@Column(name = "senha_share")
	private String senhaShare;

	@Column(name = "ip_ftp")
	private String ipFtp;

	@Column(name = "usuario_ftp")
	private String usuarioFtp;

	@Column(name = "senha_ftp")
	private String senhaFtp;

	@Column(name = "diretorio_ftp")
	private String diretorioFtp;

	@Column(name = "nome_retorno")
	private String nomeRetorno;

	@OneToOne
	@JoinColumn(name = "id_processamento")
	private Processamento processamento;

	public Long getIdRetorno() {
		return idRetorno;
	}

	public void setIdRetorno(Long idRetorno) {
		this.idRetorno = idRetorno;
	}

	public String getCaminhoShare() {
		return caminhoShare;
	}

	public void setCaminhoShare(String caminhoShare) {
		this.caminhoShare = caminhoShare;
	}

	public String getUsuarioShare() {
		return usuarioShare;
	}

	public void setUsuarioShare(String usuarioShare) {
		this.usuarioShare = usuarioShare;
	}

	public String getSenhaShare() {
		return senhaShare;
	}

	public void setSenhaShare(String senhaShare) {
		this.senhaShare = senhaShare;
	}

	public String getIpFtp() {
		return ipFtp;
	}

	public void setIpFtp(String ipFtp) {
		this.ipFtp = ipFtp;
	}

	public String getUsuarioFtp() {
		return usuarioFtp;
	}

	public void setUsuarioFtp(String usuarioFtp) {
		this.usuarioFtp = usuarioFtp;
	}

	public String getSenhaFtp() {
		return senhaFtp;
	}

	public void setSenhaFtp(String senhaFtp) {
		this.senhaFtp = senhaFtp;
	}

	public String getDiretorioFtp() {
		return diretorioFtp;
	}

	public void setDiretorioFtp(String diretorioFtp) {
		this.diretorioFtp = diretorioFtp;
	}

	public String getNomeRetorno() {
		return nomeRetorno;
	}

	public void setNomeRetorno(String nomeRetorno) {
		this.nomeRetorno = nomeRetorno;
	}

	public Processamento getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Processamento processamento) {
		this.processamento = processamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRetorno == null) ? 0 : idRetorno.hashCode());
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
		Retorno other = (Retorno) obj;
		if (idRetorno == null) {
			if (other.idRetorno != null)
				return false;
		} else if (!idRetorno.equals(other.idRetorno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}