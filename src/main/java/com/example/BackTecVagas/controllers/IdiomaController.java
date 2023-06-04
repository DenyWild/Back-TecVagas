package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.IdiomaForm;
import com.example.BackTecVagas.dto.IdiomaResponse;
import com.example.BackTecVagas.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @PostMapping
    public ResponseEntity<IdiomaResponse> cadastrarCandidato(@RequestBody IdiomaForm form) {

        IdiomaResponse response = idiomaService.cadastrarIdioma(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<IdiomaResponse> atualizarIdioma(@PathVariable Long id, @RequestBody IdiomaForm form) {

        IdiomaResponse response = idiomaService.atualizarIdioma(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<IdiomaResponse> buscaIdiomaPorId(@PathVariable Long id) {

        IdiomaResponse response = idiomaService.buscarIdiomaPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<IdiomaResponse>> listarTodosIdiomasPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<IdiomaResponse> list = idiomaService.listarTodosIdiomas(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarIdioma(@PathVariable Long id) {

        idiomaService.deletarIdioma(id);

        return ResponseEntity.noContent().build();

    }
}
