package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Long> {
}
