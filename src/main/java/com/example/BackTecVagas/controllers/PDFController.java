package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.services.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDFController {

    @Autowired
    private PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/pdf")
    public void uploadPDF(@RequestBody byte[] pdfContent) {
        pdfService.salvarPDF(pdfContent);
    }
}
