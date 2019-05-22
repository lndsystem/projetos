package com.lndsystem.monitor.entities.dto;

import java.util.List;

import com.lndsystem.monitor.entities.DadosServidor;
import com.lndsystem.monitor.entities.Servidor;

public class ServidorDTO {
	private Servidor servidor;
	private DadosServidor dadosServidorUltimo;
	private List<DadosServidor> listaDadosServidor;

	public ServidorDTO(Servidor servidor, List<DadosServidor> listaDadosServidor) {
		this.servidor = servidor;
		this.listaDadosServidor = listaDadosServidor;
		if (!listaDadosServidor.isEmpty()) {
			this.dadosServidorUltimo = ((DadosServidor) listaDadosServidor.get(0));
		}
	}

	public Servidor getServidor() {
		return this.servidor;
	}

	public List<DadosServidor> getListaDadosServidor() {
		return this.listaDadosServidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public void setListaDadosServidor(List<DadosServidor> listaDadosServidor) {
		this.listaDadosServidor = listaDadosServidor;
	}

	public DadosServidor getDadosServidorUltimo() {
		return this.dadosServidorUltimo;
	}

	public void setDadosServidorUltimo(DadosServidor dadosServidorUltimo) {
		this.dadosServidorUltimo = dadosServidorUltimo;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = 31 * result + (this.listaDadosServidor == null ? 0 : this.listaDadosServidor.hashCode());
		result = 31 * result + (this.servidor == null ? 0 : this.servidor.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ServidorDTO other = (ServidorDTO) obj;
		if (this.listaDadosServidor == null) {
			if (other.listaDadosServidor != null) {
				return false;
			}
		} else if (!this.listaDadosServidor.equals(other.listaDadosServidor)) {
			return false;
		}
		if (this.servidor == null) {
			if (other.servidor != null) {
				return false;
			}
		} else if (!this.servidor.equals(other.servidor)) {
			return false;
		}
		return true;
	}
}
