package com.example.BackTecVagas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosResponse {

    private Long id;

    private String nomeInstituicao;
    private String nomeCurso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date anoConclusaoCurso;

    private int duracaoCurso;
}
