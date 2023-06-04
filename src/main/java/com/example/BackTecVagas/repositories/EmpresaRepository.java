package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmpresaRepository extends MongoRepository<Empresa, Long> {

    @Query("{nomeEmpresa:'?0'}")
    Empresa findByNomeEmpresa(String nomeEmpresa);

}
