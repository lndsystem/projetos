package com.metasolucoes.prodkit.inspire.repository.helper.queries;

import java.util.List;

import com.metasolucoes.prodkit.inspire.model.Usuario;

public interface UsuarioQueries {

	public Usuario buscarComGrupo(Long idUsuario);

	public List<Usuario> findAllFull();
	
	public List<String> permissoes(Usuario usuario);
}
