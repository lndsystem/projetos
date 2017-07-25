package com.metasolucoes.prodkit.inspire.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metasolucoes.prodkit.inspire.dto.AlterarSenhaDto;
import com.metasolucoes.prodkit.inspire.dto.RecuperarSenhaDto;
import com.metasolucoes.prodkit.inspire.email.Mailer;
import com.metasolucoes.prodkit.inspire.model.RecuperacaoSenha;
import com.metasolucoes.prodkit.inspire.model.TipoSolicitacaoSenha;
import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.service.RecuperacaoSenhaService;
import com.metasolucoes.prodkit.inspire.service.UsuarioService;

@Controller
public class SegurancaController {

	@Autowired
	private UsuarioService usuarioServiceImpl;

	@Autowired
	private RecuperacaoSenhaService recuperacaoSenhaServiceImpl;

	@Autowired
	private Mailer mailer;

	@GetMapping("/login")
	public String login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return "redirect:/";
		}
		return "login";
	}

	@GetMapping("/recuperar")
	public ModelAndView recuperar(RecuperarSenhaDto recuperarSenhaDto) {
		return new ModelAndView("recuperar");
	}

	@GetMapping("/alterarsenha")
	public ModelAndView alterarSenha(AlterarSenhaDto alterarSenhaDto) {
		return new ModelAndView("alterarsenha");
	}

	@PostMapping("/alterarsenha")
	public ModelAndView salvarNovaSenha(@Valid AlterarSenhaDto alterarSenhaDto, BindingResult result, Model model,
			@AuthenticationPrincipal User user, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return alterarSenha(alterarSenhaDto);
		}

		if (alterarSenhaDto.getNovaSenha().equals(alterarSenhaDto.getConfirmacaoSenha()) == false) {
			result.rejectValue("confirmacaoSenha", null, "A confirmação de senha é diferente da senha");
			return alterarSenha(alterarSenhaDto);
		}
		Optional<Usuario> usuario = usuarioServiceImpl.buscarUsuarioByEmailAtivo(user.getUsername());

		RecuperacaoSenha recup = new RecuperacaoSenha();
		recup.setDataSolicitacao(LocalDateTime.now());
		recup.setTipoSolicitacaoSenha(TipoSolicitacaoSenha.ATUALIZOU);
		recup.setUsuario(usuario.get());
		recup.setUltimaSenha(usuario.get().getSenha());
		recuperacaoSenhaServiceImpl.salvar(recup);

		usuario.get().setSenha(new BCryptPasswordEncoder().encode(alterarSenhaDto.getNovaSenha()));
		usuarioServiceImpl.salvar(usuario.get());

		attributes.addFlashAttribute("mensagem", "Senha alterada com sucesso");

		return new ModelAndView("redirect:/alterarsenha");
	}

	@PostMapping("/recuperar/novasenha")
	public ModelAndView novaSenha(@Valid RecuperarSenhaDto recuperarSenhaDto, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return recuperar(recuperarSenhaDto);
		}

		Optional<Usuario> usuario = usuarioServiceImpl.buscarUsuariByEmailIgnoreCase(recuperarSenhaDto.getEmail());
		if (usuario.isPresent() == false) {
			result.rejectValue("email", "email", "E-mail informado não confere.");
			return recuperar(recuperarSenhaDto);
		}

		String novaSenha = RandomStringUtils.randomAlphabetic(8);
		String novaSenhaCript = new BCryptPasswordEncoder().encode(novaSenha).toString();

		RecuperacaoSenha recupSenha = new RecuperacaoSenha();
		recupSenha.setUsuario(usuario.get());
		recupSenha.setDataSolicitacao(LocalDateTime.now());
		recupSenha.setUltimaSenha(usuario.get().getSenha());
		recupSenha.setTipoSolicitacaoSenha(TipoSolicitacaoSenha.RECUPEROU);
		recuperacaoSenhaServiceImpl.salvar(recupSenha);

		recuperarSenhaDto.setDataSolicitacao(LocalDateTime.now());
		recuperarSenhaDto.setNovaSenha(novaSenha);
		usuario.get().setSenha(novaSenhaCript);
		usuarioServiceImpl.salvar(usuario.get());

		attributes.addFlashAttribute("mensagem_recup", "A sua nova senha será enviada ao seu e-mail!");

		mailer.recuperarSenha(recuperarSenhaDto);
		return new ModelAndView("redirect:/recuperar");
	}
}
