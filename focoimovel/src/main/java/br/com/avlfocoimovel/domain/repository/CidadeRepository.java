package br.com.avlfocoimovel.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avlfocoimovel.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public Optional<Cidade> findByNomeIgnoreCase(String nome);
}
