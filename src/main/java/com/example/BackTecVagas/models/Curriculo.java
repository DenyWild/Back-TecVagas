package com.example.BackTecVagas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Curriculo {

    @Id
    private Long id;
    private Long idCandidato;

    private List<ExperienciaProfissional> experienciaProfissional;
    private List<Cursos> cursos;
    private List<FormacaoAcademica> formacaoAcademica;
    private List<Idioma> idioma;
    private List<InformacaoAdicional> informacaoAdicional;

}
