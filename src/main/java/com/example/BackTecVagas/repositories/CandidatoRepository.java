package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Candidato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatoRepository extends MongoRepository<Candidato, Long> {

}