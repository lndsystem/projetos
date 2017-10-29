package com.lndsystem.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lndsystem.mongodb.repository.ConcursoRepository;

@SpringBootApplication
public class MegasenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegasenaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ConcursoRepository concursoRepository) {
		return args -> {
			System.out.println("Iniciando a pesquisa");

			concursoRepository.findAll().forEach(System.out::println);

			System.out.println("Finalizando a pesquisa");
		};
	}
}
