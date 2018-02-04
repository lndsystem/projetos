package com.lndsystem.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndsystem.pessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
