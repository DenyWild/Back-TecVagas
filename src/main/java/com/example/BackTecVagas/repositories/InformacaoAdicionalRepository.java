package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.InformacaoAdicional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InformacaoAdicionalRepository extends MongoRepository<InformacaoAdicional, Long> {
}
