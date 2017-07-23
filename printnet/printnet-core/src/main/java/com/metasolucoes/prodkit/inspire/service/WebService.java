package com.metasolucoes.prodkit.inspire.service;

import java.util.List;
import java.util.Optional;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.model.Usuario;

public interface WebService {
	public List<Processamento> getAllProcessamento();
	
	public List<Parametro> getParametroByIdProcessamento(Long idProcessamento);
	
	public Optional<Usuario> pesquisarUsuarioByEmail(String email);
}
