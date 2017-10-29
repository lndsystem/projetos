package com.lndsystem.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lndsystem.mongodb.documents.Car;
import com.lndsystem.mongodb.repository.CarRepository;

@SpringBootApplication
public class Ipva2014Application {

	public static void main(String[] args) {
		SpringApplication.run(Ipva2014Application.class, args);
	}

	@Bean
	CommandLineRunner init(CarRepository carRepository) {
		return args -> {
			System.out.println("Iniciando a pesquisa");

			Car car = carRepository.findOne("59e69a902bb8aac3c88c5b7d");
			
//			Car moto = carRepository.f

			System.out.println("Finalizando a pesquisa");
		};
	}
}
