package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.models.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
}
