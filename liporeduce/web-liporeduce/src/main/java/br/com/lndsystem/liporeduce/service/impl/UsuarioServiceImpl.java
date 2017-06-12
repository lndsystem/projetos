package br.com.lndsystem.liporeduce.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lndsystem.liporeduce.exception.EmailJaCadastradoException;
import br.com.lndsystem.liporeduce.modal.TipoUsuario;
import br.com.lndsystem.liporeduce.modal.Usuario;
import br.com.lndsystem.liporeduce.repository.UsuarioRepository;
import br.com.lndsystem.liporeduce.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = false)
	@Override
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> existe = usuarioRepository.findByEmailIgnoreCase(usuario.getEmail());
		if (existe.isPresent()) {
			throw new EmailJaCadastradoException(String.format("E-mail [%s] já cadastrado!", usuario.getEmail()));
		}

		return usuarioRepository.save(usuario);
	}

	@Override
	public List<TipoUsuario> getTiposUsuario(User user) {
		Optional<Usuario> usuarioLogado = usuarioRepository.findByEmailIgnoreCase(user.getUsername());

		if (!usuarioLogado.isPresent()) {
			return Arrays.asList(TipoUsuario.PACIENTE);
		} else if (usuarioLogado.get().getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)) {
			return Arrays.asList(TipoUsuario.values());
		} else if (usuarioLogado.get().getTipoUsuario().equals(TipoUsuario.ATENDENTE)) {
			return Arrays.asList(TipoUsuario.values()).stream().filter(t -> !t.equals(TipoUsuario.ADMINISTRADOR)).collect(Collectors.toList());
		} else if (usuarioLogado.get().getTipoUsuario().equals(TipoUsuario.MEDICO)) {
			return Arrays.asList(TipoUsuario.MEDICO);
		} else {
			return Arrays.asList(TipoUsuario.PACIENTE);
		}
	}

}
