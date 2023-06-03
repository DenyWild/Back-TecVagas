package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.PDFData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PDFDataRepository extends JpaRepository<PDFData, Long> {

}
