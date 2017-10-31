package com.lndsystem.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ipva2014Application {

	public static void main(String[] args) {
		SpringApplication.run(Ipva2014Application.class, args);
	}

//	@Bean
//	CommandLineRunner init(CarRepository carRepository) {
//		return args -> {
//			System.out.println("Iniciando a pesquisa");
//
//			Car car = carRepository.findByPlaca("EII3818");
//
//			System.out.println(car);
//
//			System.out.println("Finalizando a pesquisa");
//		};
//	}
}
