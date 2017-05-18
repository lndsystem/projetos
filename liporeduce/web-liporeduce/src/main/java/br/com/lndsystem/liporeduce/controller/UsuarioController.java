package br.com.lndsystem.liporeduce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.lndsystem.liporeduce.exception.EmailJaCadastradoException;
import br.com.lndsystem.liporeduce.modal.TipoUsuario;
import br.com.lndsystem.liporeduce.modal.Usuario;
import br.com.lndsystem.liporeduce.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("usuario/pesquisa-usuario");

		return mv;
	}

	@GetMapping(value = "/novo")
	public ModelAndView novo(Usuario usuario, @AuthenticationPrincipal User user) {
		ModelAndView mv = new ModelAndView("usuario/cadastro-usuario");
		mv.addObject(usuario);
		mv.addObject("tiposUsuario", usuarioService.getTiposUsuario(user));

		return mv;
	}

	@PostMapping(value = "/novo")
	public ModelAndView salvar(@AuthenticationPrincipal User user, @Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario, user);
		}

		try {
			usuarioService.salvar(usuario);
		} catch (EmailJaCadastradoException e) {
			result.rejectValue("email", null, e.getMessage());
			return novo(usuario, user);
		}

		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/usuario/novo");
	}
}
