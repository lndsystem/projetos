package br.com.lndsystem.webtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lndsystem.webtime.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

}
