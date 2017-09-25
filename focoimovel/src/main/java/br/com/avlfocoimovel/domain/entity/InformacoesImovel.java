package br.com.avlfocoimovel.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InformacoesImovel {

	private Integer dormitorios;

	private Integer suites;

	private Integer banheiros;

	private Integer lavabos;

	private Integer vagas;

	@Column(name = "area_util")
	private BigDecimal areaUtil;

	@Column(name = "area_total")
	private BigDecimal areaTotal;

	@Column(name = "valor_venda")
	private BigDecimal valorVenda;

	@Column(name = "valor_aluguel")
	private BigDecimal valorAluguel;

	@Column(name = "valor_condominio")
	private BigDecimal valorCondominio;

	@Column(name = "valor_iptu")
	private BigDecimal valorIptu;

	public Integer getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getSuites() {
		return suites;
	}

	public void setSuites(Integer suites) {
		this.suites = suites;
	}

	public Integer getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(Integer banheiros) {
		this.banheiros = banheiros;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public BigDecimal getValorCondominio() {
		return valorCondominio;
	}

	public void setValorCondominio(BigDecimal valorCondominio) {
		this.valorCondominio = valorCondominio;
	}

	public BigDecimal getValorIptu() {
		return valorIptu;
	}

	public void setValorIptu(BigDecimal valorIptu) {
		this.valorIptu = valorIptu;
	}

	public BigDecimal getAreaUtil() {
		return areaUtil;
	}

	public void setAreaUtil(BigDecimal areaUtil) {
		this.areaUtil = areaUtil;
	}

	public BigDecimal getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Integer getLavabos() {
		return lavabos;
	}

	public void setLavabos(Integer lavabos) {
		this.lavabos = lavabos;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	@Override
	public String toString() {
		return "Diferenciais [dormitorios=" + dormitorios + ", suites=" + suites + ", banheiros=" + banheiros
				+ ", areaUtil=" + areaUtil + ", areaTotal=" + areaTotal + ", valorVenda=" + valorVenda
				+ ", valorAluguel=" + valorAluguel + ", valorCondominio=" + valorCondominio + ", valorIptu=" + valorIptu
				+ "]";
	}
}
