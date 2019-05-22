package com.lndsystem.monitor.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "perfil", catalog = "monitor_servicos", schema = "dbo")
@Table(name = "perfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "descricao_perfil", length = 100)
	private String descricaoPerfil;

	@JoinTable(name = "perfil_servidor", joinColumns = {
			@JoinColumn(name = "id_perfil", referencedColumnName = "id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_servidor", referencedColumnName = "id", nullable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Servidor> servidorCollection;

	public Collection<Servidor> getServidorCollection() {
		return this.servidorCollection;
	}

	public void setServidorCollection(Collection<Servidor> servidorCollection) {
		this.servidorCollection = servidorCollection;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", descricaoPerfil=" + descricaoPerfil + ", servidorCollection="
				+ servidorCollection + "]";
	}
}
