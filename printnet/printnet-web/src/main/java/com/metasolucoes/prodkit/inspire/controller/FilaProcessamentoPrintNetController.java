package com.metasolucoes.prodkit.inspire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metasolucoes.prodkit.inspire.service.WebService;

@Controller
@RequestMapping("/printnet")
public class FilaProcessamentoPrintNetController {

	@Autowired
	private WebService webService;

	@GetMapping("")
	public ModelAndView filaProcessamento() {
		ModelAndView mv = new ModelAndView("printnet/fila-processamento");

		mv.addObject("fila", webService.getAllProcessamento());

		return mv;
	}
}
