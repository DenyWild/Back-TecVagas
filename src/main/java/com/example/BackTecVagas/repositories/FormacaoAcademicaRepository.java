package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Long> {
}
