package com.metasolucoes.prodkit.inspire.service;

import java.util.List;
import java.util.Optional;

import com.metasolucoes.prodkit.inspire.model.Usuario;

public interface UsuarioService {

	public Usuario buscarUsuarioByIdUsuario(Long idUsuario);
	
	public Optional<Usuario> buscarUsuariByEmailIgnoreCase(String email);
	
	public Optional<Usuario> buscarUsuarioByEmailAtivo(String email);

	public List<String> permissoes(Usuario usuario);
	
	public Usuario salvar(Usuario usuario);

}
