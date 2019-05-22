package com.lndsystem.mongodb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.lndsystem.mongodb.repository.ConcursoRepository;

@SpringBootApplication
public class MegasenaApplication {

	public static void main(String[] args) {

		Set<Long> x = new HashSet<>();
		x.add(1l);
		x.add(2l);

		Set<Long> y = new HashSet<>();
		y.add(2l);

		SetView<Long> difference = Sets.difference(x, y);

		System.out.println();

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
