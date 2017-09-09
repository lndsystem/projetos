package com.metasolucoes.prodkit.inspire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metasolucoes.prodkit.inspire.model.Execucao;
import com.metasolucoes.prodkit.inspire.service.ExecucaoService;

@RestController
@RequestMapping("/execucao")
public class ExecucaoController {

	@Autowired
	private ExecucaoService execucaoServiceImp;

	@GetMapping(value = "/{idProcessamento}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Execucao> getExecucaoByIdProcessamento(
			@PathVariable("idProcessamento") Long idProcessamento) {
		return execucaoServiceImp.findByIdProcessamento(idProcessamento);
	}
}
