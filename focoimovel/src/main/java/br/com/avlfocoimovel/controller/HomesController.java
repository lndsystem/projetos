package br.com.avlfocoimovel.controller;

import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomesController extends AbstractResultController {

	private static final String VIEW_NAME = "home";

	@Override
	String getViewName() {
		return VIEW_NAME;
	}

	@Override
	Validator getValidator() {
		return null;
	}

}
