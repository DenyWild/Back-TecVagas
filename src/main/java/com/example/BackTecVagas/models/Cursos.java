package com.example.BackTecVagas.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {

    @Id
    private Long id;

    private String nomeInstituicao;
    private String nomeCurso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date anoConclusaoCurso;

    private int duracaoCurso;

    private Curriculo curriculo;

}
