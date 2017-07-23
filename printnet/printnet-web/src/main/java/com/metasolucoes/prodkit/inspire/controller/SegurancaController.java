package com.metasolucoes.prodkit.inspire.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metasolucoes.prodkit.inspire.dto.RecuperarSenhaDto;
import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.service.WebService;

@Controller
public class SegurancaController {
	
	@Autowired
	private WebService webService;

	@RequestMapping("/login")
	public String login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return "redirect:/";
		}
		return "login";
	}

	@RequestMapping("/recuperar")
	public ModelAndView recuperar(RecuperarSenhaDto recuperarSenhaDto) {
		return new ModelAndView("recuperar");
	}

	@PostMapping("/recuperar/novasenha")
	public ModelAndView novaSenha(@Valid RecuperarSenhaDto recuperarSenhaDto, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return recuperar(recuperarSenhaDto);
		}
		
		Optional<Usuario> usuario = webService.pesquisarUsuarioByEmail(recuperarSenhaDto.getEmail());
		if(usuario.isPresent() == false){
			result.rejectValue("email", "email", "E-mail informado não confere.");
			return recuperar(recuperarSenhaDto);
		}
		
		String novaSenha = RandomStringUtils.randomAlphabetic(8);
		String novaSenhaCript = new BCryptPasswordEncoder().encode(novaSenha).toString();
		
		
		System.out.println(String.format("%s : %s", novaSenha, novaSenhaCript));
		attributes.addFlashAttribute("mensagem_recup", "A sua nova senha será enviada ao seu e-mail!");

		return new ModelAndView("redirect:/recuperar");
	}
}
