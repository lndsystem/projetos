package com.lndsystem.monitor.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "dados_servidor", catalog = "monitor_servicos", schema = "dbo")
@Table(name = "dados_servidor")
public class DadosServidor {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idServidor;

	@Column(name = "data", nullable = false)
	private Date data;

	@Column(name = "memoria_total_mb")
	private Long memoriaTotalMb;

	@Column(name = "memoria_usada_mb")
	private Long memoriaUsadaMb;

	@Column(name = "memoria_livre_mb")
	private Long memoriaLivreMb;

	@Column(name = "memoria_percent_usado")
	private Double memoriaPercentUsado;

	@Column(name = "memoria_percent_free")
	private Double memoriaPercentFree;

	@Column(name = "uso_cpu_percent")
	private Double usoCPUPercent;

	private String arquitetura;

	private Integer nucleos;

	private String sistemaOperacional;

	private Long diskSize;

	private Long diskSizeFree;

	private Long diskSizeUsage;

	private String diskSizePorEscrito;

	private String diskSizeFreePorEscrito;

	private String diskSizeUsagePorEscrito;

	private Integer id_status;

	public Long getIdServidor() {
		return this.idServidor;
	}

	public Date getData() {
		return this.data;
	}

	public Long getMemoriaTotalMb() {
		return this.memoriaTotalMb;
	}

	public Long getMemoriaUsadaMb() {
		return this.memoriaUsadaMb;
	}

	public Long getMemoriaLivreMb() {
		return this.memoriaLivreMb;
	}

	public Double getMemoriaPercentUsado() {
		return this.memoriaPercentUsado;
	}

	public Double getMemoriaPercentFree() {
		return this.memoriaPercentFree;
	}

	public Double getUsoCPUPercent() {
		return this.usoCPUPercent;
	}

	public String getArquitetura() {
		return this.arquitetura;
	}

	public Integer getNucleos() {
		return this.nucleos;
	}

	public String getSistemaOperacional() {
		return this.sistemaOperacional;
	}

	public Long getDiskSize() {
		return this.diskSize;
	}

	public Long getDiskSizeFree() {
		return this.diskSizeFree;
	}

	public Long getDiskSizeUsage() {
		return this.diskSizeUsage;
	}

	public String getDiskSizePorEscrito() {
		return this.diskSizePorEscrito;
	}

	public String getDiskSizeFreePorEscrito() {
		return this.diskSizeFreePorEscrito;
	}

	public String getDiskSizeUsagePorEscrito() {
		return this.diskSizeUsagePorEscrito;
	}

	public void setIdServidor(Long idServidor) {
		this.idServidor = idServidor;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setMemoriaTotalMb(Long memoriaTotalMb) {
		this.memoriaTotalMb = memoriaTotalMb;
	}

	public void setMemoriaUsadaMb(Long memoriaUsadaMb) {
		this.memoriaUsadaMb = memoriaUsadaMb;
	}

	public void setMemoriaLivreMb(Long memoriaLivreMb) {
		this.memoriaLivreMb = memoriaLivreMb;
	}

	public void setMemoriaPercentUsado(Double memoriaPercentUsado) {
		this.memoriaPercentUsado = memoriaPercentUsado;
	}

	public void setMemoriaPercentFree(Double memoriaPercentFree) {
		this.memoriaPercentFree = memoriaPercentFree;
	}

	public void setUsoCPUPercent(Double usoCPUPercent) {
		this.usoCPUPercent = usoCPUPercent;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public void setNucleos(Integer nucleos) {
		this.nucleos = nucleos;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public void setDiskSize(Long diskSize) {
		this.diskSize = diskSize;
	}

	public void setDiskSizeFree(Long diskSizeFree) {
		this.diskSizeFree = diskSizeFree;
	}

	public void setDiskSizeUsage(Long diskSizeUsage) {
		this.diskSizeUsage = diskSizeUsage;
	}

	public void setDiskSizePorEscrito(String diskSizePorEscrito) {
		this.diskSizePorEscrito = diskSizePorEscrito;
	}

	public void setDiskSizeFreePorEscrito(String diskSizeFreePorEscrito) {
		this.diskSizeFreePorEscrito = diskSizeFreePorEscrito;
	}

	public void setDiskSizeUsagePorEscrito(String diskSizeUsagePorEscrito) {
		this.diskSizeUsagePorEscrito = diskSizeUsagePorEscrito;
	}

	public Integer getId_status() {
		return this.id_status;
	}

	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DadosServidor other = (DadosServidor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosServidor [id=" + id + ", idServidor=" + idServidor + ", data=" + data + ", memoriaTotalMb="
				+ memoriaTotalMb + ", memoriaUsadaMb=" + memoriaUsadaMb + ", memoriaLivreMb=" + memoriaLivreMb
				+ ", memoriaPercentUsado=" + memoriaPercentUsado + ", memoriaPercentFree=" + memoriaPercentFree
				+ ", usoCPUPercent=" + usoCPUPercent + ", arquitetura=" + arquitetura + ", nucleos=" + nucleos
				+ ", sistemaOperacional=" + sistemaOperacional + ", diskSize=" + diskSize + ", diskSizeFree="
				+ diskSizeFree + ", diskSizeUsage=" + diskSizeUsage + ", diskSizePorEscrito=" + diskSizePorEscrito
				+ ", diskSizeFreePorEscrito=" + diskSizeFreePorEscrito + ", diskSizeUsagePorEscrito="
				+ diskSizeUsagePorEscrito + ", id_status=" + id_status + "]";
	}
}
