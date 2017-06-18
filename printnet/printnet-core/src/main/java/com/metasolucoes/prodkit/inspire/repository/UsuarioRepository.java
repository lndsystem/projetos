package com.metasolucoes.prodkit.inspire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.repository.helper.queries.UsuarioQueries;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioQueries {

	public Optional<Usuario> findByEmailIgnoreCase(String email);
	
	public Optional<Usuario> findByEmailIgnoreCaseAndAtivoTrue(String email);
}
