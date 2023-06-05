package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    public Empresa findByNomeEmpresa(String nomeEmpresa);

}
