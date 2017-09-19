package br.com.avlfocoimovel.controller;

import javax.validation.Validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractResultController {
	// abstract ResultGenerator GetResultGenerator();
	abstract String getViewName();

	abstract Validator getValidator();

	@GetMapping(value = "/{q:.+}")
	final ModelAndView getModelAndView(@PathVariable("q") String q) {

		ModelAndView model = new ModelAndView();
		// Map<String, Object> results =
		// GetResultGenerator().getResultForController(q);
		// model.addObject("data", results);
		model.addObject("email", "xpto@seila.com.br");
		model.setViewName(getViewName());

		return model;
	}
}
