package br.com.lndsystem.webtime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.lndsystem.webtime.model.dto.PontoDTO;

@RestController
@RequestMapping
public class PontoController {

	@GetMapping
	public ModelAndView getPontos(){
		ModelAndView mv = new ModelAndView("relatorio-ponto");
		
		return mv;
	}
	
	@GetMapping("/criar")
	public ModelAndView criarPonto(PontoDTO pontoDto){
		ModelAndView mv = new ModelAndView("criar-ponto");
		
		return mv;
	}
}
