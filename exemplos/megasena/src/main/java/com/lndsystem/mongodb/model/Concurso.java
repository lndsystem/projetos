package com.lndsystem.mongodb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

@Document(collection = "megasena")
public class Concurso {

	@Id
	@Field("_id")
	private String id;

	@Field("Concurso")
	private Integer concurso;

	@Field("Data Sorteio")
	private String dataSorteio;

	@Field("1ª Dezena")
	private Integer dezena1;

	@Field("2ª Dezena")
	private Integer dezena2;

	@Field("3ª Dezena")
	private Integer dezena3;

	@Field("4ª Dezena")
	private Integer dezena4;

	@Field("5ª Dezena")
	private Integer dezena5;

	@Field("6ª Dezena")
	private Integer dezena6;

	@Field("Arrecadacao_Total")
	private String arrecadacaoTotal;

	@Field("Ganhadores_Sena")
	private Integer ganhadoresSenha;

	@Field("Cidade")
	private String cidade;

	@Field("UF")
	private String uf;

	@Field("Rateio_Sena")
	private String rateioSena;

	@Field("Ganhadores_Quina")
	private Integer ganhadoresQuina;

	@Field("Rateio_Quina")
	private String rateioQuina;

	@Field("Ganhadores_Quadra")
	private Integer ganhadoresQuadra;

	@Field("Rateio_Quadra")
	private String rateioQuadra;

	@Field("Acumulado")
	private String acumulado;

	@Field("Valor_Acumulado")
	private String valorAcumulado;

	@Field("Estimativa_Prêmio")
	private String estimativaPremio;

	@Field("Acumulado_Mega_da_Virada")
	private String acumuladoMegaVirada;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getConcurso() {
		return concurso;
	}

	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}

	public String getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(String dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	public Integer getDezena1() {
		return dezena1;
	}

	public void setDezena1(Integer dezena1) {
		this.dezena1 = dezena1;
	}

	public Integer getDezena2() {
		return dezena2;
	}

	public void setDezena2(Integer dezena2) {
		this.dezena2 = dezena2;
	}

	public Integer getDezena3() {
		return dezena3;
	}

	public void setDezena3(Integer dezena3) {
		this.dezena3 = dezena3;
	}

	public Integer getDezena4() {
		return dezena4;
	}

	public void setDezena4(Integer dezena4) {
		this.dezena4 = dezena4;
	}

	public Integer getDezena5() {
		return dezena5;
	}

	public void setDezena5(Integer dezena5) {
		this.dezena5 = dezena5;
	}

	public Integer getDezena6() {
		return dezena6;
	}

	public void setDezena6(Integer dezena6) {
		this.dezena6 = dezena6;
	}

	public String getArrecadacaoTotal() {
		return arrecadacaoTotal;
	}

	public void setArrecadacaoTotal(String arrecadacaoTotal) {
		this.arrecadacaoTotal = arrecadacaoTotal;
	}

	public Integer getGanhadoresSenha() {
		return ganhadoresSenha;
	}

	public void setGanhadoresSenha(Integer ganhadoresSenha) {
		this.ganhadoresSenha = ganhadoresSenha;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRateioSena() {
		return rateioSena;
	}

	public void setRateioSena(String rateioSena) {
		this.rateioSena = rateioSena;
	}

	public Integer getGanhadoresQuina() {
		return ganhadoresQuina;
	}

	public void setGanhadoresQuina(Integer ganhadoresQuina) {
		this.ganhadoresQuina = ganhadoresQuina;
	}

	public String getRateioQuina() {
		return rateioQuina;
	}

	public void setRateioQuina(String rateioQuina) {
		this.rateioQuina = rateioQuina;
	}

	public Integer getGanhadoresQuadra() {
		return ganhadoresQuadra;
	}

	public void setGanhadoresQuadra(Integer ganhadoresQuadra) {
		this.ganhadoresQuadra = ganhadoresQuadra;
	}

	public String getRateioQuadra() {
		return rateioQuadra;
	}

	public void setRateioQuadra(String rateioQuadra) {
		this.rateioQuadra = rateioQuadra;
	}

	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public String getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(String valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public String getEstimativaPremio() {
		return estimativaPremio;
	}

	public void setEstimativaPremio(String estimativaPremio) {
		this.estimativaPremio = estimativaPremio;
	}

	public String getAcumuladoMegaVirada() {
		return acumuladoMegaVirada;
	}

	public void setAcumuladoMegaVirada(String acumuladoMegaVirada) {
		this.acumuladoMegaVirada = acumuladoMegaVirada;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
