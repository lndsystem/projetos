package com.lndsystem.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndsystem.monitor.entities.EnderecoMonitor;

public interface EnderecoMonitorRepository extends JpaRepository<EnderecoMonitor, Integer> {
	public List<EnderecoMonitor> findAllByPerfilId(Integer id);
}
