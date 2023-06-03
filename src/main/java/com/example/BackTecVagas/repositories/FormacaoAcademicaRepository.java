package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.models.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Long> {
}
