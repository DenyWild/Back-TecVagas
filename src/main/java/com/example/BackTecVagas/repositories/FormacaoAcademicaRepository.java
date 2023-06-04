package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.FormacaoAcademica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormacaoAcademicaRepository extends MongoRepository<FormacaoAcademica, Long> {
}
