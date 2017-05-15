package br.com.lndsystem.liporeduce.modal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.NumberFormat;

@Embeddable
public class Barriga implements Serializable {

	private static final long serialVersionUID = 2035741185340767571L;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo8Menos;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo6Menos;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo4Menos;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo2Menos;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo2Mais;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo4Mais;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo6Mais;

	@NumberFormat(pattern = "#,###.000")
	private BigDecimal umbigo8Mais;

	public BigDecimal getUmbigo8Menos() {
		return umbigo8Menos;
	}

	public void setUmbigo8Menos(BigDecimal umbigo8Menos) {
		this.umbigo8Menos = umbigo8Menos;
	}

	public BigDecimal getUmbigo6Menos() {
		return umbigo6Menos;
	}

	public void setUmbigo6Menos(BigDecimal umbigo6Menos) {
		this.umbigo6Menos = umbigo6Menos;
	}

	public BigDecimal getUmbigo4Menos() {
		return umbigo4Menos;
	}

	public void setUmbigo4Menos(BigDecimal umbigo4Menos) {
		this.umbigo4Menos = umbigo4Menos;
	}

	public BigDecimal getUmbigo2Menos() {
		return umbigo2Menos;
	}

	public void setUmbigo2Menos(BigDecimal umbigo2Menos) {
		this.umbigo2Menos = umbigo2Menos;
	}

	public BigDecimal getUmbigo() {
		return umbigo;
	}

	public void setUmbigo(BigDecimal umbigo) {
		this.umbigo = umbigo;
	}

	public BigDecimal getUmbigo2Mais() {
		return umbigo2Mais;
	}

	public void setUmbigo2Mais(BigDecimal umbigo2Mais) {
		this.umbigo2Mais = umbigo2Mais;
	}

	public BigDecimal getUmbigo4Mais() {
		return umbigo4Mais;
	}

	public void setUmbigo4Mais(BigDecimal umbigo4Mais) {
		this.umbigo4Mais = umbigo4Mais;
	}

	public BigDecimal getUmbigo6Mais() {
		return umbigo6Mais;
	}

	public void setUmbigo6Mais(BigDecimal umbigo6Mais) {
		this.umbigo6Mais = umbigo6Mais;
	}

	public BigDecimal getUmbigo8Mais() {
		return umbigo8Mais;
	}

	public void setUmbigo8Mais(BigDecimal umbigo8Mais) {
		this.umbigo8Mais = umbigo8Mais;
	}
}