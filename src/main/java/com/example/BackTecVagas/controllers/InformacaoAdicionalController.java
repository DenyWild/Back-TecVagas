package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.InformacaoAdicionalForm;
import com.example.BackTecVagas.dto.InformacaoAdicionalResponse;
import com.example.BackTecVagas.services.InformacaoAdicionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inf-adicional")
public class InformacaoAdicionalController {

    @Autowired
    private InformacaoAdicionalService informacaoAdicionalService;

    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoAdicionalResponse> cadastrarInformacaoAdicional(InformacaoAdicionalForm form) {

        InformacaoAdicionalResponse response = informacaoAdicionalService.cadastrarInformacaoAdicional(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<InformacaoAdicionalResponse> atualizarInformacaoAdicional(@PathVariable Long id, @RequestBody InformacaoAdicionalForm form) {

        InformacaoAdicionalResponse response = informacaoAdicionalService.atualizarInformacaoAdicional(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InformacaoAdicionalResponse> buscaInformacaoAdicionalPorId(@PathVariable Long id) {

        InformacaoAdicionalResponse response = informacaoAdicionalService.buscarInformacaoAdicionalPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<InformacaoAdicionalResponse>> listarTodasInformacoesAdicionaisPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<InformacaoAdicionalResponse> list = informacaoAdicionalService.listarTodasInformacoesAdicionais(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> deletarInformacaoAdicional(@PathVariable Long id) {

        informacaoAdicionalService.deletarInformacaoAdicional(id);

        return ResponseEntity.noContent().build();

    }
}
