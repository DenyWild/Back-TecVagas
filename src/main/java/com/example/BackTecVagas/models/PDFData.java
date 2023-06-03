package com.example.BackTecVagas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pdf_data")
public class PDFData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] content;

    // Getters e Setters
}
