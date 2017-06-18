package com.metasolucoes.prodkit.inspire.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.service.UsuarioService;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioServiceImpl.buscarUsuarioByEmailAtivo(username);
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("usuário e/ou senha incorretos"));

		return new UsuarioSistema(usuario, getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		// Lista de permissões do usuário
		List<String> permissoes = usuarioServiceImpl.permissoes(usuario);
		permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));

		return authorities;
	}

}
