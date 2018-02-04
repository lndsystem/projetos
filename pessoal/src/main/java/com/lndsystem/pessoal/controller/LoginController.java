package com.lndsystem.pessoal.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping("/login")
	public ModelAndView login(@AuthenticationPrincipal User user) {
		if(user != null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("login");
	}
	
}
