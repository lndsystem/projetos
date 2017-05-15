package br.com.lndsystem.liporeduce.modal;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Patologias implements Serializable {

	private static final long serialVersionUID = -2515406464193094135L;

	private boolean cardiaca;

	private String descricaoCardiaca;

	private boolean ginecologica;

	private String descricaoGinecologica;

	private boolean circulatoria;

	private String descricaoCirculatoria;

	private boolean renal;

	private String descricaoRenal;

	private boolean endocrina;

	private String descricaoEndocrina;

	private boolean ortopedica;

	private String descricaoOrtopedica;

	private boolean alergica;

	private String descricaoAlergica;

	public boolean isCardiaca() {
		return cardiaca;
	}

	public void setCardiaca(boolean cardiaca) {
		this.cardiaca = cardiaca;
	}

	public String getDescricaoCardiaca() {
		return descricaoCardiaca;
	}

	public void setDescricaoCardiaca(String descricaoCardiaca) {
		this.descricaoCardiaca = descricaoCardiaca;
	}

	public boolean isGinecologica() {
		return ginecologica;
	}

	public void setGinecologica(boolean ginecologica) {
		this.ginecologica = ginecologica;
	}

	public String getDescricaoGinecologica() {
		return descricaoGinecologica;
	}

	public void setDescricaoGinecologica(String descricaoGinecologica) {
		this.descricaoGinecologica = descricaoGinecologica;
	}

	public boolean isCirculatoria() {
		return circulatoria;
	}

	public void setCirculatoria(boolean circulatoria) {
		this.circulatoria = circulatoria;
	}

	public String getDescricaoCirculatoria() {
		return descricaoCirculatoria;
	}

	public void setDescricaoCirculatoria(String descricaoCirculatoria) {
		this.descricaoCirculatoria = descricaoCirculatoria;
	}

	public boolean isRenal() {
		return renal;
	}

	public void setRenal(boolean renal) {
		this.renal = renal;
	}

	public String getDescricaoRenal() {
		return descricaoRenal;
	}

	public void setDescricaoRenal(String descricaoRenal) {
		this.descricaoRenal = descricaoRenal;
	}

	public boolean isEndocrina() {
		return endocrina;
	}

	public void setEndocrina(boolean endocrina) {
		this.endocrina = endocrina;
	}

	public String getDescricaoEndocrina() {
		return descricaoEndocrina;
	}

	public void setDescricaoEndocrina(String descricaoEndocrina) {
		this.descricaoEndocrina = descricaoEndocrina;
	}

	public boolean isOrtopedica() {
		return ortopedica;
	}

	public void setOrtopedica(boolean ortopedica) {
		this.ortopedica = ortopedica;
	}

	public String getDescricaoOrtopedica() {
		return descricaoOrtopedica;
	}

	public void setDescricaoOrtopedica(String descricaoOrtopedica) {
		this.descricaoOrtopedica = descricaoOrtopedica;
	}

	public boolean isAlergica() {
		return alergica;
	}

	public void setAlergica(boolean alergica) {
		this.alergica = alergica;
	}

	public String getDescricaoAlergica() {
		return descricaoAlergica;
	}

	public void setDescricaoAlergica(String descricaoAlergica) {
		this.descricaoAlergica = descricaoAlergica;
	}
}
