package com.lndsystem.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lndsystem.mongodb.documents.Car;

public interface CarRepository extends MongoRepository<Car, String> {

	public Optional<Car> findByPlaca(String placa);

	public Optional<Car> findByRenavan(Integer renavan);

	public List<Car> findByCpfCnpj(long cpfCnpj);
}
