package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.PDFData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PDFDataRepository extends MongoRepository<PDFData, Long> {

}
