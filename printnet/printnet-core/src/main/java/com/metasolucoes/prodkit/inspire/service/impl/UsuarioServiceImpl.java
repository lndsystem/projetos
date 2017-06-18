package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.repository.UsuarioRepository;
import com.metasolucoes.prodkit.inspire.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario buscarUsuarioByIdUsuario(Long idUsuario) {
		return usuarioRepository.buscarComGrupo(idUsuario);
	}

	@Override
	public Optional<Usuario> buscarUsuariByEmailIgnoreCase(String email) {
		return usuarioRepository.findByEmailIgnoreCase(email);
	}

	@Override
	public List<String> permissoes(Usuario usuario) {
		return usuarioRepository.permissoes(usuario);
	}

	@Override
	public Optional<Usuario> buscarUsuarioByEmailAtivo(String email) {
		return usuarioRepository.findByEmailIgnoreCaseAndAtivoTrue(email);
	}
}
