package com.example.BackTecVagas.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("pdf_data")
public class PDFData {

    private Long id;

    private byte[] content;

    // Getters e Setters
}
