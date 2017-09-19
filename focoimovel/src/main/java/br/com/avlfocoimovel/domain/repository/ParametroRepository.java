package br.com.avlfocoimovel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avlfocoimovel.domain.entity.Parametro;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long> {

	public Parametro findByChaveIgnoreCase(String chave);
}
