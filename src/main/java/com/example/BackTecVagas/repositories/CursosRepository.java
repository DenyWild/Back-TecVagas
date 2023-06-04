package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Cursos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursosRepository extends MongoRepository<Cursos, Long> {
}
