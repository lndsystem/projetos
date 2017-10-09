package br.com.avlfocoimovel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.avlfocoimovel.domain.service.ImovelService;
import br.com.avlfocoimovel.domain.service.TipoImovelService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ImovelService imovelService;

	@Autowired
	private TipoImovelService tipoImovelService;

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("true_list", true);
		mv.addObject("imoveis", imovelService.pesquisarTodos());
		mv.addObject("destaques", imovelService.pesquisarTodosDestaques());
		mv.addObject("ofertas", imovelService.pesquisarTodasOfertas());
		mv.addObject("tiposImoveis", tipoImovelService.pesquisarTodos());
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
}
