package com.metasolucoes.prodkit.inspire.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.model.RecuperacaoSenha;
import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.repository.ParamentroRepository;
import com.metasolucoes.prodkit.inspire.repository.ProcessamentoRepository;
import com.metasolucoes.prodkit.inspire.repository.UsuarioRepository;
import com.metasolucoes.prodkit.inspire.service.RecuperacaoSenhaService;
import com.metasolucoes.prodkit.inspire.service.WebService;

@Service
public class WebServiceImpl implements WebService {

	@Autowired
	private ParamentroRepository parametroRepository;

	@Autowired
	private ProcessamentoRepository processamentoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RecuperacaoSenhaService recuepracaoSenhaService;

	@Override
	public List<Processamento> getAllProcessamento() {
		return processamentoRepository.findAll();
	}

	@Override
	public List<Parametro> getParametroByIdProcessamento(Long idProcessamento) {
		return parametroRepository.findParametroByProcessamentoIdProcessamento(idProcessamento);
	}

	@Override
	public Optional<Usuario> pesquisarUsuarioByEmail(String email) {
		return usuarioRepository.findByEmailIgnoreCaseAndAtivoTrue(email);
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public RecuperacaoSenha salvarRecuperarSenha(RecuperacaoSenha recuperacaoSenha) {
		return recuepracaoSenhaService.salvar(recuperacaoSenha);
	}
}