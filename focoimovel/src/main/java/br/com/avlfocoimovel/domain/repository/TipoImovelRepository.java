package br.com.avlfocoimovel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avlfocoimovel.domain.entity.TipoImovel;

public interface TipoImovelRepository extends JpaRepository<TipoImovel, Long> {

}
