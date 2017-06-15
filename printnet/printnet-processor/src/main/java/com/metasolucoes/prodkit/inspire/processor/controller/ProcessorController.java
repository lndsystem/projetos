package com.metasolucoes.prodkit.inspire.processor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metasolucoes.prodkit.inspire.model.Status;
import com.metasolucoes.prodkit.inspire.repository.StatusRepository;

@Controller
public class ProcessorController {

	@Autowired
	private StatusRepository statusRepository;

	public void executar(String... args) throws Exception {

		Status s = new Status();
		s.setDescricao("Teste");
		s.setCor("#FFFFFF");

		statusRepository.save(s);

	}

}
