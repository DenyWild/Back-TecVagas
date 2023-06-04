package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurriculoRepository extends MongoRepository<Curriculo, Long> {
}
