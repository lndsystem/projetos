package com.metasolucoes.prodkit.inspire.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_permissao", schema = "dbo", catalog = "prodkit_inspire")
public class GrupoPermissao implements Serializable {

	private static final long serialVersionUID = 8361485188631925313L;

	@EmbeddedId
	private GrupoPermissaoId id;

	public GrupoPermissaoId getId() {
		return id;
	}

	public void setId(GrupoPermissaoId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GrupoPermissao other = (GrupoPermissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}