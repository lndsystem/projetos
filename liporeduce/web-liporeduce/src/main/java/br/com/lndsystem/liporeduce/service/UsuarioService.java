package br.com.lndsystem.liporeduce.service;

import org.springframework.stereotype.Service;

import br.com.lndsystem.liporeduce.modal.Usuario;

@Service
public interface UsuarioService {

	public Usuario salvar(Usuario usuario);
}
