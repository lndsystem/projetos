package br.com.avlfocoimovel.domain.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

	private static final long serialVersionUID = -4533659380130540307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "id_finalidade")
	private Finalidade finalidade;

	@NotBlank(message = "Titulo é obrigatório")
	@Size(min = 5, message = "Titulo deve ter no mínimo 5 caracteres")
	private String titulo;

	@Embedded
	private Endereco endereco;

	@Embedded
	private InformacoesImovel informacoesImoveis;

	private boolean termos;

	private boolean ativo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Finalidade getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(Finalidade finalidade) {
		this.finalidade = finalidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public InformacoesImovel getInformacoesImoveis() {
		return informacoesImoveis;
	}

	public void setInformacoesImoveis(InformacoesImovel informacoesImoveis) {
		this.informacoesImoveis = informacoesImoveis;
	}

	public boolean isTermos() {
		return termos;
	}

	public void setTermos(boolean termos) {
		this.termos = termos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
		Imovel other = (Imovel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Imovel [codigo=" + codigo + ", finalidade=" + finalidade + ", titulo=" + titulo + ", endereco=" + endereco + ", diferenciais=" + informacoesImoveis + ", termos=" + termos + ", ativo="
				+ ativo + "]";
	}
}
