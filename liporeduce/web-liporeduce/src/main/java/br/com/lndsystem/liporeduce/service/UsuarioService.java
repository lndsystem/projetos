package br.com.lndsystem.liporeduce.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.com.lndsystem.liporeduce.modal.TipoUsuario;
import br.com.lndsystem.liporeduce.modal.Usuario;

@Service
public interface UsuarioService {

	public Usuario salvar(Usuario usuario);

	public List<TipoUsuario> getTiposUsuario(User user);
}
