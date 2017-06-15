package com.metasolucoes.prodkit.inspire.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.metasolucoes.prodkit.inspire.processor.controller.ProcessorController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.metasolucoes.prodkit.inspire" })
public class ProcessorApplication implements CommandLineRunner {

	@Autowired
	private ProcessorController processorController;

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Iniciando a aplicacao");

		processorController.executar(arg0);

		System.out.println("Finalizando a aplicacao");
	}
}
