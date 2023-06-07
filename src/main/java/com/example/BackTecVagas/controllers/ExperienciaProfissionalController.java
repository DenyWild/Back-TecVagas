package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.ExperienciaProfissionalForm;
import com.example.BackTecVagas.dto.ExperienciaProfissionalResponse;
import com.example.BackTecVagas.services.ExperienciaProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exp-profissional")
public class ExperienciaProfissionalController {

    @Autowired
    private ExperienciaProfissionalService experienciaProfissionalService;

    @PostMapping
    public ResponseEntity<ExperienciaProfissionalResponse> cadastrarExperienciaProfissional(@RequestBody ExperienciaProfissionalForm form) {

        ExperienciaProfissionalResponse response = experienciaProfissionalService.cadastrarExperienciaProfissional(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<ExperienciaProfissionalResponse> atualizarExperienciaProfissional(@PathVariable Long id, @RequestBody ExperienciaProfissionalForm form) {

        ExperienciaProfissionalResponse response = experienciaProfissionalService.atualizarExperienciaProfissional(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExperienciaProfissionalResponse> buscaExperienciaProfissionalPorId(@PathVariable Long id) {

        ExperienciaProfissionalResponse response = experienciaProfissionalService.buscarExperienciaProfissionalPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<ExperienciaProfissionalResponse>> listarTodasExperienciasProfissionaisPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<ExperienciaProfissionalResponse> list = experienciaProfissionalService.listarTodasExperienciasProfissionais(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarExperienciaProfissional(@PathVariable Long id) {

        experienciaProfissionalService.deletarExperienciaProfissional(id);

        return ResponseEntity.noContent().build();

    }
}
