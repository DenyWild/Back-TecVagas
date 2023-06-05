package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.dto.CursosForm;
import com.example.BackTecVagas.dto.CursosResponse;
import com.example.BackTecVagas.services.CursosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @PostMapping
    @Transactional
    public ResponseEntity<CursosResponse> cadastrarCurso(CursosForm form) {

        CursosResponse response = cursosService.cadastrarCurso(form);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }



    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<CursosResponse> atualizarCurso(@PathVariable Long id, @RequestBody CursosForm form) {

        CursosResponse response = cursosService.atualizarCurso(id, form);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CursosResponse> buscaCursoPorId(@PathVariable Long id) {

        CursosResponse response = cursosService.buscarCursoPorId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @GetMapping
    public ResponseEntity<Page<CursosResponse>> listarTodosCursosPorPagina(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);

        Page<CursosResponse> list = cursosService.listarTodosCursos(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> deletarCurso(@PathVariable Long id) {

        cursosService.deletarCurso(id);

        return ResponseEntity.noContent().build();

    }
}
