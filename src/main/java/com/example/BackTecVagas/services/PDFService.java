package com.example.BackTecVagas.services;

import com.example.BackTecVagas.models.PDFData;
import com.example.BackTecVagas.repositories.PDFDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PDFService {

    @Autowired
    private PDFDataRepository pdfDataRepository;

    public PDFService(PDFDataRepository pdfDataRepository) {
        this.pdfDataRepository = pdfDataRepository;
    }

    public void salvarPDF(byte[] pdfContent) {
        PDFData pdfData = new PDFData();
        pdfData.setContent(pdfContent);
        pdfDataRepository.save(pdfData);
    }
}