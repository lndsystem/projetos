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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "recuperacao_senha", schema = "dbo", catalog = "prodkit_inspire")
public class RecuperacaoSenha implements Serializable {

	private static final long serialVersionUID = 7659252588387734866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRecuperacaoSenha;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_solicitacao")
	private LocalDateTime dataSolicitacao;

	@Column(name = "ultima_senha")
	private String ultimaSenha;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_solicitacao_senha")
	private TipoSolicitacaoSenha tipoSolicitacaoSenha;

	public Long getIdRecuperacaoSenha() {
		return idRecuperacaoSenha;
	}

	public void setIdRecuperacaoSenha(Long idRecuperacaoSenha) {
		this.idRecuperacaoSenha = idRecuperacaoSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getUltimaSenha() {
		return ultimaSenha;
	}

	public void setUltimaSenha(String ultimaSenha) {
		this.ultimaSenha = ultimaSenha;
	}

	public TipoSolicitacaoSenha getTipoSolicitacaoSenha() {
		return tipoSolicitacaoSenha;
	}

	public void setTipoSolicitacaoSenha(TipoSolicitacaoSenha tipoSolicitacaoSenha) {
		this.tipoSolicitacaoSenha = tipoSolicitacaoSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRecuperacaoSenha == null) ? 0 : idRecuperacaoSenha.hashCode());
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
		RecuperacaoSenha other = (RecuperacaoSenha) obj;
		if (idRecuperacaoSenha == null) {
			if (other.idRecuperacaoSenha != null)
				return false;
		} else if (!idRecuperacaoSenha.equals(other.idRecuperacaoSenha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}