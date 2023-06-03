package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.CandidatoForm;
import com.example.BackTecVagas.dto.CandidatoResponse;
import com.example.BackTecVagas.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<CandidatoResponse> cadastrarCandidato(CandidatoForm candidato) {

        CandidatoResponse response = candidatoService.cadastrarCandidato(candidato);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CandidatoResponse> atualizarCandidato(@PathVariable Long id, @RequestBody CandidatoForm form) {

        CandidatoResponse response = candidatoService.atualizarCandidato(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CandidatoResponse> buscaCandidatoPorId(@PathVariable Long id) {

        CandidatoResponse response = candidatoService.buscarCandidatoPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<CandidatoResponse>> listarTodosCandidatoPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<CandidatoResponse> list = candidatoService.listarTodosCandidatos(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarCandidato(@PathVariable Long id) {

        candidatoService.deletarCandidato(id);

        return ResponseEntity.noContent().build();

    }


}

