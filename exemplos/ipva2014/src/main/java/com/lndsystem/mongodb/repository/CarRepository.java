package com.lndsystem.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lndsystem.mongodb.documents.Car;

public interface CarRepository extends MongoRepository<Car, String> {

	public Car findByPlaca(String placa);
}
