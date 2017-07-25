package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.repository.UsuarioRepository;
import com.metasolucoes.prodkit.inspire.service.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario buscarUsuarioByIdUsuario(Long idUsuario) {
		return repository.buscarComGrupo(idUsuario);
	}

	@Override
	public Optional<Usuario> buscarUsuariByEmailIgnoreCase(String email) {
		return repository.findByEmailIgnoreCase(email);
	}

	@Override
	public List<String> permissoes(Usuario usuario) {
		return repository.permissoes(usuario);
	}

	@Override
	public Optional<Usuario> buscarUsuarioByEmailAtivo(String email) {
		return repository.findByEmailIgnoreCaseAndAtivoTrue(email);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}

}
