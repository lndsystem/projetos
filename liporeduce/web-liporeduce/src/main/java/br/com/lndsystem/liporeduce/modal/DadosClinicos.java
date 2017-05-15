package br.com.lndsystem.liporeduce.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dados_clinicos")
public class DadosClinicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@OneToOne
	@JoinColumn(columnDefinition = "codigo_usuario")
	private Usuario usuario;

	@Column(name = "queixa_principal")
	private String queixaPrincipal;

	@Embedded
	private Habitos habitos;

	@Embedded
	private Patologias patologias;

	private boolean gestacao;

	private Integer semanas;

	@Column(name = "tratamentos_anteriores")
	private String tratamentosAnteriores;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getQueixaPrincipal() {
		return queixaPrincipal;
	}

	public void setQueixaPrincipal(String queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}

	public Habitos getHabitos() {
		return habitos;
	}

	public void setHabitos(Habitos habitos) {
		this.habitos = habitos;
	}

	public Patologias getPatologias() {
		return patologias;
	}

	public void setPatologias(Patologias patologias) {
		this.patologias = patologias;
	}

	public boolean isGestacao() {
		return gestacao;
	}

	public void setGestacao(boolean gestacao) {
		this.gestacao = gestacao;
	}

	public Integer getSemanas() {
		return semanas;
	}

	public void setSemanas(Integer semanas) {
		this.semanas = semanas;
	}

	public String getTratamentosAnteriores() {
		return tratamentosAnteriores;
	}

	public void setTratamentosAnteriores(String tratamentosAnteriores) {
		this.tratamentosAnteriores = tratamentosAnteriores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		DadosClinicos other = (DadosClinicos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
