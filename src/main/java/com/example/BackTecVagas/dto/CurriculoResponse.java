package com.example.BackTecVagas.dto;

import com.example.BackTecVagas.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculoResponse {

    private Long id;

    private Long idCandidato;

    private List<ExperienciaProfissional> experienciaProfissional;

    private List<Cursos> cursos;

    private List<FormacaoAcademica> formacaoAcademica;

    private List<Idioma> idioma;

    private List<InformacaoAdicional> informacaoAdicional;

}
