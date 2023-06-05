package com.example.BackTecVagas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "idioma")
public class Idioma {

    @Id
    private Long id;
    private String idioma;
    private String nivelIdioma;
    private Curriculo curriculo;
}
