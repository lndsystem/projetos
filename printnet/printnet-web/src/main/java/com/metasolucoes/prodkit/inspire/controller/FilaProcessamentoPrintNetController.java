package com.metasolucoes.prodkit.inspire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.metasolucoes.prodkit.inspire.model.Parametro;
import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.service.ProcessamentoService;

@RestController
@RequestMapping("/printnet")
public class FilaProcessamentoPrintNetController {

	@Autowired
	private ProcessamentoService processamentoServiceImpl;

	@GetMapping
	public ModelAndView filaProcessamento() {
		ModelAndView mv = new ModelAndView("printnet/fila-processamento");
		mv.addObject("fila", processamentoServiceImpl.getAllProcessamento());
		return mv;
	}

	@PutMapping("")
	public @ResponseBody ResponseEntity<List<Parametro>> getParametroProcesso(
			@PathVariable("idProcessamento") Processamento processamento) {

		return ResponseEntity.ok(new ArrayList<>());
	}
}
