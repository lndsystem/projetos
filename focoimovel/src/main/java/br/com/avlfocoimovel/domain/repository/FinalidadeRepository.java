package br.com.avlfocoimovel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avlfocoimovel.domain.entity.Finalidade;

@Repository
public interface FinalidadeRepository extends JpaRepository<Finalidade, Long>{

}
