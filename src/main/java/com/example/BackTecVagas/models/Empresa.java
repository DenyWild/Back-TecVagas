package com.example.BackTecVagas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Empresa extends Usuario {

    @Id
    private Long id;

    private String nomeEmpresa;

    private String cnpj;

    private List<Vagas> vagas;

}
