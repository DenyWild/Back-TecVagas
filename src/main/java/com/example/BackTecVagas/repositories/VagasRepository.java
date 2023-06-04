package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Vagas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VagasRepository extends MongoRepository<Vagas, Long> {
}
