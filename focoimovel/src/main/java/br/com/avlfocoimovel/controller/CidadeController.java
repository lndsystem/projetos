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
import br.com.avlfocoimovel.domain.service.CidadeService;
import br.com.avlfocoimovel.domain.service.EstadoService;
import br.com.avlfocoimovel.exception.CidadeJaCadastradaException;

@Controller
@RequestMapping("/admin/cidade")
public class CidadeController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public ModelAndView pesquisa(CidadeFilter cidadeFilter) {
		ModelAndView mv = new ModelAndView("admin/cidade/pesquisa_cidade");
		mv.addObject("estados", estadoService.pesquisarTodos());
		mv.addObject("cidades", cidadeService.pesquisarTodos());
		return mv;
	}

	@GetMapping("/delete/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo) {
		cidadeService.remover(codigo);
		return new ModelAndView("redirect:/admin/cidade");
	}

	@GetMapping("/novo")
	public ModelAndView form(Cidade cidade) {
		ModelAndView mv = new ModelAndView("admin/cidade/cadastro_cidade");
		mv.addObject("estados", estadoService.pesquisarTodos());
		return mv;
	}

	@GetMapping("/edit/{codigo}")
	public ModelAndView edit(@PathVariable("codigo") Long codigo) {
		Cidade cidade = cidadeService.pesquisar(codigo);
		ModelAndView mv = form(cidade);
		mv.addObject(cidade);
		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return form(cidade);
		}

		try {
			cidadeService.salvar(cidade);
		} catch (CidadeJaCadastradaException e) {
			result.rejectValue("nome", null, e.getMessage());
			return form(cidade);
		}

		return new ModelAndView("redirect:/admin/cidade");
	}

}
