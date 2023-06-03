package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.models.InformacaoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacaoAdicionalRepository extends JpaRepository<InformacaoAdicional, Long> {
}
