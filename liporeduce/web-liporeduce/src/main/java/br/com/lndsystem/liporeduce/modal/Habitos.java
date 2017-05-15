package br.com.lndsystem.liporeduce.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Habitos implements Serializable {

	private static final long serialVersionUID = 5747873391078635586L;

	@Column(name = "atividade_fisica")
	private boolean atividadeFisica;

	@Column(name = "descricao_atividade_fisica")
	private String descricaoAtividadeFisica;

	private String sono;

	private boolean fumo;

	@Column(name = "descricao_fumo")
	private String descricaoFumo;

	private boolean alcool;

	@Column(name = "descricao_alcool")
	private String descricaoAlcool;

	private boolean dieta;

	@Column(name = "descricao_dieta")
	private String descricaoDieta;

	private String liquidos;

	@Column(name = "constipacao_intestinal")
	private String constipacaoIntestinal;

	private boolean medicamentos;

	@Column(name = "descricao_medicamentos")
	private String descricaoMedicamentos;

	public boolean isAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(boolean atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	public String getDescricaoAtividadeFisica() {
		return descricaoAtividadeFisica;
	}

	public void setDescricaoAtividadeFisica(String descricaoAtividadeFisica) {
		this.descricaoAtividadeFisica = descricaoAtividadeFisica;
	}

	public String getSono() {
		return sono;
	}

	public void setSono(String sono) {
		this.sono = sono;
	}

	public boolean isFumo() {
		return fumo;
	}

	public void setFumo(boolean fumo) {
		this.fumo = fumo;
	}

	public String getDescricaoFumo() {
		return descricaoFumo;
	}

	public void setDescricaoFumo(String descricaoFumo) {
		this.descricaoFumo = descricaoFumo;
	}

	public boolean isAlcool() {
		return alcool;
	}

	public void setAlcool(boolean alcool) {
		this.alcool = alcool;
	}

	public String getDescricaoAlcool() {
		return descricaoAlcool;
	}

	public void setDescricaoAlcool(String descricaoAlcool) {
		this.descricaoAlcool = descricaoAlcool;
	}

	public boolean isDieta() {
		return dieta;
	}

	public void setDieta(boolean dieta) {
		this.dieta = dieta;
	}

	public String getDescricaoDieta() {
		return descricaoDieta;
	}

	public void setDescricaoDieta(String descricaoDieta) {
		this.descricaoDieta = descricaoDieta;
	}

	public String getLiquidos() {
		return liquidos;
	}

	public void setLiquidos(String liquidos) {
		this.liquidos = liquidos;
	}

	public String getConstipacaoIntestinal() {
		return constipacaoIntestinal;
	}

	public void setConstipacaoIntestinal(String constipacaoIntestinal) {
		this.constipacaoIntestinal = constipacaoIntestinal;
	}

	public boolean isMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(boolean medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getDescricaoMedicamentos() {
		return descricaoMedicamentos;
	}

	public void setDescricaoMedicamentos(String descricaoMedicamentos) {
		this.descricaoMedicamentos = descricaoMedicamentos;
	}
}
