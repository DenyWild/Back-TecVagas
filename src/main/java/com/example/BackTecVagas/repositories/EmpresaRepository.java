package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByNomeEmpresa(String nomeEmpresa);

}
