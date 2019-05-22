package com.lndsystem.monitor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="servidor", catalog="monitor_servicos", schema="dbo")
@Table(name = "servidor")
public class Servidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", length = 150)
	private String descricao;

	@Column(name = "ip", length = 50)
	private String ip;

	@Column(name = "interno")
	private Boolean interno;

	@Column(name = "ativo")
	private Boolean ativo;

	public String getDescricao() {
		return this.descricao;
	}

	public String getIp() {
		return this.ip;
	}

	public Boolean getInterno() {
		return this.interno;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setInterno(Boolean interno) {
		this.interno = interno;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		Servidor other = (Servidor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servidor [id=" + id + ", descricao=" + descricao + ", ip=" + ip + ", interno=" + interno + ", ativo="
				+ ativo + "]";
	}
}
