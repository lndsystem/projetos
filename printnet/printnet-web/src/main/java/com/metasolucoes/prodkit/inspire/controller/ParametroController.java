package com.metasolucoes.prodkit.inspire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.service.ParametroService;

@RestController
@RequestMapping("/parametro")
public class ParametroController {

	@Autowired
	private ParametroService parametroServiceImpl;

	@GetMapping(value = "/{idProcessamento}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Parametro> getParametroByIdProcessamento(
			@PathVariable(name = "idProcessamento") Processamento processamento) {
		return parametroServiceImpl.getParametroByIdProcessamento(processamento.getIdProcessamento());

	}
}
