package br.com.avlfocoimovel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avlfocoimovel.domain.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
