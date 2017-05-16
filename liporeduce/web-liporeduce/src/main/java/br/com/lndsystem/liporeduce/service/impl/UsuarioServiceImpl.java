package br.com.lndsystem.liporeduce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lndsystem.liporeduce.exception.EmailJaCadastradoException;
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

}
