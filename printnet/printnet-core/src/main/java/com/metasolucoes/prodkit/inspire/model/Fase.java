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
@Table(name = "fase", schema = "dbo", catalog = "prodkit_inspire")
public class Fase implements Serializable {

	private static final long serialVersionUID = -8672293452080831537L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fase")
	private Long idFase;

	@NotBlank(message = "Nome da fase é obrigatória")
	@Column(name = "nome_fase")
	private String nomeFase;

	public Long getIdFase() {
		return idFase;
	}

	public void setIdFase(Long idFase) {
		this.idFase = idFase;
	}

	public String getNomeFase() {
		return nomeFase;
	}

	public void setNomeFase(String nomeFase) {
		this.nomeFase = nomeFase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFase == null) ? 0 : idFase.hashCode());
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
		Fase other = (Fase) obj;
		if (idFase == null) {
			if (other.idFase != null)
				return false;
		} else if (!idFase.equals(other.idFase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}