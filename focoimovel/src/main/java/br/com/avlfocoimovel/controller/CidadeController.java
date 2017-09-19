package br.com.avlfocoimovel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.avlfocoimovel.domain.entity.Cidade;
import br.com.avlfocoimovel.domain.filters.CidadeFilter;
import br.com.avlfocoimovel.domain.repository.CidadeRepository;
import br.com.avlfocoimovel.domain.service.EstadoService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public ModelAndView pesquisa(CidadeFilter cidadeFilter) {
		ModelAndView mv = new ModelAndView("cidade/pesquisa_cidade");
		mv.addObject("estados", estadoService.pesquisarTodos());
		mv.addObject("cidades", cidadeRepository.findAll());
		return mv;
	}

	@GetMapping("/delete/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo) {
		cidadeRepository.delete(codigo);
		return new ModelAndView("redirect:/cidade");
	}

	@GetMapping("/novo")
	public ModelAndView form(Cidade cidade) {
		ModelAndView mv = new ModelAndView("cidade/cadastro_cidade");
		mv.addObject("estados", estadoService.pesquisarTodos());
		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cidade cidade, Model model, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return form(cidade);
		}

		cidadeRepository.save(cidade);
		return new ModelAndView("redirect:/cidade");
	}

}
