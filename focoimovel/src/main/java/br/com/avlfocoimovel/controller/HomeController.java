package br.com.avlfocoimovel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("acesso_login");
		return mv;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView("user_register");
		return mv;
	}

	@GetMapping("/contato")
	public ModelAndView contato() {
		ModelAndView mv = new ModelAndView("info_contato");
		return mv;
	}

	@GetMapping("/emconstrucao")
	public ModelAndView emConstrucao() {
		ModelAndView mv = new ModelAndView("emconstrucao");
		return mv;
	}
	
	@GetMapping("/listaimoveis")
	public ModelAndView listaImovies(){
		ModelAndView mv = new ModelAndView("lista_imoveis");
		return mv;
	}
}
