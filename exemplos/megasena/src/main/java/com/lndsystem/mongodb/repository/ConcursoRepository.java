package com.lndsystem.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lndsystem.mongodb.model.Concurso;

public interface ConcursoRepository extends MongoRepository<Concurso, String>{

}
