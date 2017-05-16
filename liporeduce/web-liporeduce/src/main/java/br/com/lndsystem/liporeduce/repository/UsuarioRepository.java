package br.com.lndsystem.liporeduce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lndsystem.liporeduce.modal.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
