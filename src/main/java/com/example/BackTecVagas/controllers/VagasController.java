package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.VagasForm;
import com.example.BackTecVagas.dto.VagasResponse;
import com.example.BackTecVagas.services.VagasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vagas")
public class VagasController {


    @Autowired
    private VagasService vagasService;

    @PostMapping
    @Transactional
    public ResponseEntity<VagasResponse> cadastrarVaga(VagasForm form) {

        VagasResponse response = vagasService.cadastrarVaga(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<VagasResponse> cadastrarVagaComEmpresa(@PathVariable Long id, String nomeEmpresa) {

        VagasResponse response = vagasService.cadastrarVagaComEmpresa(id, nomeEmpresa);

        return ResponseEntity.ok().body(response);

    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<VagasResponse> atualizarVaga(@PathVariable Long id, @RequestBody VagasForm form) {

        VagasResponse response = vagasService.atualizarVaga(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VagasResponse> buscaVagaPorId(@PathVariable Long id) {

        VagasResponse response = vagasService.buscarVagaPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<VagasResponse>> listarTodasVagasPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<VagasResponse> list = vagasService.listarTodasVagas(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> deletarVaga(@PathVariable Long id) {

        vagasService.deletarVaga(id);

        return ResponseEntity.noContent().build();

    }
}
