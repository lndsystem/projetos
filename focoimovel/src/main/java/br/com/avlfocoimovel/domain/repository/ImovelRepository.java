package br.com.avlfocoimovel.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avlfocoimovel.domain.entity.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

	public List<Imovel> findAllByAtivoTrueAndOfertaTrue();

	public List<Imovel> findAllByAtivoTrueAndDestaqueTrue();

	public List<Imovel> findAllByAtivoTrue();
}
