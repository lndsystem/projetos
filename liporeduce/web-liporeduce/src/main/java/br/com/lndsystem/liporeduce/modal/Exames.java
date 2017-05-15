package br.com.lndsystem.liporeduce.modal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Exames implements Serializable {

	private static final long serialVersionUID = 1047602734362396706L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(columnDefinition = "codigo_usuario")
	private Usuario usuario;

	@Column(name = "data_exame")
	private LocalDateTime dataExame;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal colesterol;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal hdl;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal ldl;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal vldl;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal trig;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal tgo;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal tgp;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal tsh;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal t3;

	@NumberFormat(pattern = "#,###.0000")
	private BigDecimal t4;

	@Column(length = 500)
	private String outros;

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

	public LocalDateTime getDataExame() {
		return dataExame;
	}

	public void setDataExame(LocalDateTime dataExame) {
		this.dataExame = dataExame;
	}

	public BigDecimal getColesterol() {
		return colesterol;
	}

	public void setColesterol(BigDecimal colesterol) {
		this.colesterol = colesterol;
	}

	public BigDecimal getHdl() {
		return hdl;
	}

	public void setHdl(BigDecimal hdl) {
		this.hdl = hdl;
	}

	public BigDecimal getLdl() {
		return ldl;
	}

	public void setLdl(BigDecimal ldl) {
		this.ldl = ldl;
	}

	public BigDecimal getTrig() {
		return trig;
	}

	public void setTrig(BigDecimal trig) {
		this.trig = trig;
	}

	public BigDecimal getTgo() {
		return tgo;
	}

	public void setTgo(BigDecimal tgo) {
		this.tgo = tgo;
	}

	public BigDecimal getTgp() {
		return tgp;
	}

	public void setTgp(BigDecimal tgp) {
		this.tgp = tgp;
	}

	public BigDecimal getTsh() {
		return tsh;
	}

	public void setTsh(BigDecimal tsh) {
		this.tsh = tsh;
	}

	public BigDecimal getT3() {
		return t3;
	}

	public void setT3(BigDecimal t3) {
		this.t3 = t3;
	}

	public BigDecimal getT4() {
		return t4;
	}

	public void setT4(BigDecimal t4) {
		this.t4 = t4;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
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
		Exames other = (Exames) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
