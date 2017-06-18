package com.metasolucoes.prodkit.inspire.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.metasolucoes.prodkit.inspire.model.Usuario;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 8481512472370629383L;

	private Usuario usuario;

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}