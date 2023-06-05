package com.example.BackTecVagas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculo")
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCandidato;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculo")
    private List<ExperienciaProfissional> experienciaProfissional;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculo")
    private List<Cursos> cursos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculo")
    private List<FormacaoAcademica> formacaoAcademica;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculo")
    private List<Idioma> idioma;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculo")
    private List<InformacaoAdicional> informacaoAdicional;

}
