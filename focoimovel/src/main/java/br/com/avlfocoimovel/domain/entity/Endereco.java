package br.com.avlfocoimovel.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Endereco {

	@NotBlank(message = "Logradouro é obrigatório")
	@Size(min = 5, message = "Logradouro deve ter no mínimo 5 caracteres")
	private String logradouro;

	@NotBlank(message = "Número é obrigatório")
	private String numero;

	private String complemento;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@NotBlank(message = "Bairro é obrigatório")
	@Size(min = 2, message = "Bairro deve ter no mínimo 2 caracteres")
	private String bairro;

	@NotBlank(message = "Cep é obrigatório")
	@Size(min = 8, max = 8, message = "Cep tem que ter 8 caracteres")
	private String cep;

	private String referencia;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", bairro=" + bairro + ", cep=" + cep + ", referencia="
				+ referencia + "]";
	}

}