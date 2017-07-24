package com.metasolucoes.prodkit.inspire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metasolucoes.prodkit.inspire.model.RecuperacaoSenha;

@Repository
public interface RecuperacaoSenhaRepository extends JpaRepository<RecuperacaoSenha, Long>{

}
