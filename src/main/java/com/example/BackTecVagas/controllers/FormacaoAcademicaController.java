package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.FormacaoAcademicaForm;
import com.example.BackTecVagas.dto.FormacaoAcademicaResponse;
import com.example.BackTecVagas.services.FormacaoAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formacao-acad")
public class FormacaoAcademicaController {

    @Autowired
    private FormacaoAcademicaService formacaoAcademicaService;

    @PostMapping
    public ResponseEntity<FormacaoAcademicaResponse> cadastrarFormacaoAcademica(FormacaoAcademicaForm form) {

        FormacaoAcademicaResponse response = formacaoAcademicaService.cadastrarFormmacaoAcademica(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<FormacaoAcademicaResponse> atualizarFormacaoAcademica(@PathVariable Long id, @RequestBody FormacaoAcademicaForm form) {

        FormacaoAcademicaResponse response = formacaoAcademicaService.atualizarFormmacaoAcademica(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FormacaoAcademicaResponse> buscaFormacaoAcademicaPorId(@PathVariable Long id) {

        FormacaoAcademicaResponse response = formacaoAcademicaService.buscarFormmacaoAcademicaPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<FormacaoAcademicaResponse>> listarTodasFormacoesAcademicasPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<FormacaoAcademicaResponse> list = formacaoAcademicaService.listarTodasFormmacoesAcademicas(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarFormacaoAcademica(@PathVariable Long id) {

        formacaoAcademicaService.deletarFormmacaoAcademica(id);

        return ResponseEntity.noContent().build();

    }
}
