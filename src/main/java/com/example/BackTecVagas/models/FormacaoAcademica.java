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
@Table(name = "form-academica")
public class FormacaoAcademica {

    @Id
    private Long id;

    private String nivel;
    private String nomeCurso;
    private String nomeInstituicao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date inicioFormacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date conclusaoFormacao;

    private Curriculo curriculo;

}
