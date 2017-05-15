package br.com.lndsystem.liporeduce.modal;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.NumberFormat;

@Embeddable
public class Demais {

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal quadril;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal culote;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal MID;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal MIE;

	public BigDecimal getCulote() {
		return culote;
	}

	public void setCulote(BigDecimal culote) {
		this.culote = culote;
	}

	public BigDecimal getMID() {
		return MID;
	}

	public void setMID(BigDecimal mID) {
		MID = mID;
	}

	public BigDecimal getMIE() {
		return MIE;
	}

	public void setMIE(BigDecimal mIE) {
		MIE = mIE;
	}

	public BigDecimal getQuadril() {
		return quadril;
	}

	public void setQuadril(BigDecimal quadril) {
		this.quadril = quadril;
	}
}
