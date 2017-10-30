package com.lndsystem.mongodb.documents;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ipva2014")
public class Car {

	@Id
	@Field(value = "_id")
	private String id;

	@Indexed(unique = true)
	@Field(value = "PLACA")
	private String placa;

	@Field(value = "CHASSI")
	private String chassi;

	@Indexed(unique = true)
	@Field(value = "RENAVAN")
	private Integer renavan;

	@Field(value = "CD_MUNICIPIO")
	private Integer codigoMunicipio;

	@Field(value = "IDENT_FINAL_PLACA")
	private Integer finalPlaca;

	@Field(value = "NOME_MUNICIPIO")
	private String nomeMunicipio;

	@Field(value = "MARCA_MODELO")
	private String marcaModelo;

	@Field(value = "ANO_FABRICACAO")
	private Integer anoFabricacao;

	@Field(value = "COMBUSTIVEL")
	private String combustivel;

	@Field(value = "ESPECIE_TIPO")
	private String especieTipo;

	@Field(value = "PROCEDENCIA")
	private String procedencia;

	@Field(value = "TIPO")
	private Integer tipo;

	@Field(value = "NOME_PROPRIETARIO")
	private String nomeProprietario;

	@Field(value = "NOME_RESPONSAVEL")
	private String nomeResponsavel;

	@Field(value = "LOGRADOURO")
	private String logradouro;

	@Field(value = "NUMERO")
	private Integer numero;

	@Field(value = "COMPLEMENTO")
	private String complemento;

	@Field(value = "BAIRRO")
	private String bairro;

	@Field(value = "CEP")
	private Integer cep;

	@Field(value = "CD_MUNICIPIO_ENDERECO")
	private Integer codigoMunicipioEndereco;

	@Field(value = "CIDADE")
	private String cidade;

	@Field(value = "COD_ISENCAO")
	private Integer codIsencao;

	@Indexed
	@Field(value = "CPF_CNPJ")
	private long cpfCnpj;

	public String getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getChassi() {
		return chassi;
	}

	public Integer getRenavan() {
		return renavan;
	}

	public void setRenavan(Integer renavan) {
		this.renavan = renavan;
	}

	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public Integer getFinalPlaca() {
		return finalPlaca;
	}

	public void setFinalPlaca(Integer finalPlaca) {
		this.finalPlaca = finalPlaca;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getEspecieTipo() {
		return especieTipo;
	}

	public void setEspecieTipo(String especieTipo) {
		this.especieTipo = especieTipo;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getCodigoMunicipioEndereco() {
		return codigoMunicipioEndereco;
	}

	public void setCodigoMunicipioEndereco(Integer codigoMunicipioEndereco) {
		this.codigoMunicipioEndereco = codigoMunicipioEndereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCodIsencao() {
		return codIsencao;
	}

	public void setCodIsencao(Integer codIsencao) {
		this.codIsencao = codIsencao;
	}

	public long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
