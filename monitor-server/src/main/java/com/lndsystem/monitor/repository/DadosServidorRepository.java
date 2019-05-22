package com.lndsystem.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndsystem.monitor.entities.DadosServidor;

public interface DadosServidorRepository extends JpaRepository<DadosServidor, Long> {
	public List<DadosServidor> findTop50ByIdServidorOrderByDataDesc(Long paramLong);
}
