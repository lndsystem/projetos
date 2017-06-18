package com.metasolucoes.prodkit.inspire.processor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.service.UsuarioService;

@Controller
public class ProcessorController {

	@Autowired
	private UsuarioService usuarioServiceImpl;

	public void executar(String... args) throws Exception {

		Usuario u = usuarioServiceImpl.buscarUsuarioByIdUsuario(1l);
		System.out.println(u.toString());

		System.out.println("Fim");

	}

}
