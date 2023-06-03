package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.models.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagasRepository extends JpaRepository<Vagas, Long> {
}
