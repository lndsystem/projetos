package br.com.lndsystem.liporeduce.modal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = -8122402009146587989L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(columnDefinition = "codigo_usuario")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(columnDefinition = "codigo_medico")
	private Usuario medico;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataConsulta;

	private Integer diaCiclo;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal peso;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal percentualGordura;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal percentualH2O;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal massaMuscular;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal indiceAbdome;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal imc;

	@Embedded
	private Barriga barriga;

	@Embedded
	private Demais demais;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Integer getDiaCiclo() {
		return diaCiclo;
	}

	public void setDiaCiclo(Integer diaCiclo) {
		this.diaCiclo = diaCiclo;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(BigDecimal percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public BigDecimal getPercentualH2O() {
		return percentualH2O;
	}

	public void setPercentualH2O(BigDecimal percentualH2O) {
		this.percentualH2O = percentualH2O;
	}

	public BigDecimal getMassaMuscular() {
		return massaMuscular;
	}

	public void setMassaMuscular(BigDecimal massaMuscular) {
		this.massaMuscular = massaMuscular;
	}

	public BigDecimal getIndiceAbdome() {
		return indiceAbdome;
	}

	public void setIndiceAbdome(BigDecimal indiceAbdome) {
		this.indiceAbdome = indiceAbdome;
	}

	public BigDecimal getImc() {
		return imc;
	}

	public void setImc(BigDecimal imc) {
		this.imc = imc;
	}

	public Barriga getBarriga() {
		return barriga;
	}

	public void setBarriga(Barriga barriga) {
		this.barriga = barriga;
	}

	public Demais getDemais() {
		return demais;
	}

	public void setDemais(Demais demais) {
		this.demais = demais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
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
		Consulta other = (Consulta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
