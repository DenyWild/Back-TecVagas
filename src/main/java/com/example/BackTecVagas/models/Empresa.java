package com.example.BackTecVagas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "empresa")
public class Empresa extends Usuario {

    @Id
    private Long id;

    private String nomeEmpresa;

    private String cnpj;

    private List<Vagas> vagas;

}
