package com.metasolucoes.prodkit.inspire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "status", schema = "dbo", catalog = "prodkit_inspire")
public class Status implements Serializable {

	private static final long serialVersionUID = 6865079164882167097L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status")
	private Long idStatus;

	@NotBlank(message = "Descrição é obrigatória.")
	@Column(length = 70)
	private String descricao;

	@NotBlank(message = "Cor é obrigatória")
	@Column(length = 7)
	private String cor;

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStatus == null) ? 0 : idStatus.hashCode());
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
		Status other = (Status) obj;
		if (idStatus == null) {
			if (other.idStatus != null)
				return false;
		} else if (!idStatus.equals(other.idStatus))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
