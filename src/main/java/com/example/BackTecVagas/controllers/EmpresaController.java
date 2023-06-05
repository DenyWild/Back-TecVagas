package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.EmpresaForm;
import com.example.BackTecVagas.dto.EmpresaResponse;
import com.example.BackTecVagas.services.EmpresaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {


    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaResponse> cadastrarEmpresa(EmpresaForm candidato) {

        EmpresaResponse response = empresaService.cadastrarEmpresa(candidato);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<EmpresaResponse> atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaForm form) {

        EmpresaResponse response = empresaService.atualizarEmpresa(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmpresaResponse> buscaEmpresaPorId(@PathVariable Long id) {

        EmpresaResponse response = empresaService.buscarEmpresaPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<EmpresaResponse>> listarTodasEmpresasPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<EmpresaResponse> list = empresaService.listarTodasEmpresas(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> deletarEmpresa(@PathVariable Long id) {

        empresaService.deletarEmpresa(id);

        return ResponseEntity.noContent().build();

    }


}
