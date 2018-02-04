package com.lndsystem.pessoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "/", "/dashboard" })
public class DashboardController {

	@GetMapping
	public ModelAndView texte() {
		return new ModelAndView("dashboard");
	}
}
