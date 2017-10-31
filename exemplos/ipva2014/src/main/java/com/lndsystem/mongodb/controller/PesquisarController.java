package com.lndsystem.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lndsystem.mongodb.documents.Car;
import com.lndsystem.mongodb.filter.Filter;
import com.lndsystem.mongodb.repository.CarRepository;

@PropertySource(value = "fabricante.properties")
@Controller
@RequestMapping
public class PesquisarController {

	@Autowired
	private Environment env;

	@Autowired
	private CarRepository carRepository;

	@GetMapping
	public ModelAndView home(Filter filter) {
		return new ModelAndView("index");
	}

	@PostMapping
	public ModelAndView pesquisar(Filter filter, BindingResult result, Model model, RedirectAttributes attributes) {

		if (StringUtils.isEmpty(filter.getPlaca()) && (filter.getRenavan() == null || (filter.getRenavan() != null && filter.getRenavan().intValue() == 0))
				&& StringUtils.isEmpty(filter.getCpfCnpj())) {
			result.rejectValue("placa", null, "Obrigatório preencher um dos campos");
			result.rejectValue("renavan", null, "Obrigatório preencher um dos campos");
			result.rejectValue("cpfCnpj", null, "Obrigatório preencher um dos campos");

			return home(filter);
		}

		ModelAndView mv = home(filter);

		List<Car> carros = new ArrayList<>();

		if (StringUtils.isEmpty(filter.getPlaca()) == false) {
			Optional<Car> findByPlaca = carRepository.findByPlaca(filter.getPlaca().replace("-", "").toUpperCase());
			if (findByPlaca.isPresent()) {
				carros.add(findByPlaca.get());
			}
		}

		if (filter.getRenavan() != null && filter.getRenavan().intValue() > 0) {
			Optional<Car> findByRenavan = carRepository.findByRenavan(filter.getRenavan());
			if (findByRenavan.isPresent()) {
				carros.add(findByRenavan.get());
			}
		}

		if (StringUtils.isEmpty(filter.getCpfCnpj()) == false) {
			carros.addAll(carRepository.findByCpfCnpj(Long.parseLong(filter.getCpfCnpj())));
		}

		mv.addObject("resultado", "achou");
		if (carros.isEmpty() == false) {
			carros.parallelStream().forEach(c -> {

				String fabricante = env.getProperty(c.getChassi().substring(0, 3));
				if (StringUtils.isEmpty(fabricante)) {
					fabricante = env.getProperty(c.getChassi().substring(0, 2));
				}

				if (StringUtils.isEmpty(fabricante)) {
					c.setFabricante(String.format("Fabricante não localizado"));
				} else {
					c.setFabricante(fabricante);
				}
			});

			mv.addObject("veiculos", carros);
		}

		return mv;
	}
}
