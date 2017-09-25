package br.com.avlfocoimovel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.avlfocoimovel.domain.entity.Imovel;
import br.com.avlfocoimovel.domain.service.DiferenciaisService;
import br.com.avlfocoimovel.domain.service.EstadoService;
import br.com.avlfocoimovel.domain.service.FinalidadeService;

@Controller
@RequestMapping("/imoveis")
public class ImoveisController {

	@Autowired
	private FinalidadeService finalidadeService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private DiferenciaisService diferenciaisService;

	@GetMapping("/novo")
	public ModelAndView novo(Imovel imovel) {
		ModelAndView mv = new ModelAndView("imoveis/cadastro_imoveis");

		mv.addObject("finalidades", finalidadeService.pesquisarTodos());
		mv.addObject("estados", estadoService.pesquisarTodos());
		mv.addObject("diferenciais", diferenciaisService.pesquisarTodos());

		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Imovel imovel, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			if(imovel.isTermos() == false){
				result.rejectValue("termos", null, "Você não concordou com os termos de divulgação");
			}
			return novo(imovel);
		}
		
		
		if(imovel.isTermos() == false){
			result.rejectValue("termos", null, "Você não concordou com os termos de divulgação");
			return novo(imovel);
		}

		return new ModelAndView("redirect:/imoveis/novo");
	}
}
