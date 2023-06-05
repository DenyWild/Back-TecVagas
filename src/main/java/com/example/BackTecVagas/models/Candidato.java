package com.example.BackTecVagas.models;

import com.example.BackTecVagas.models.enums.Regiao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidato")
public class Candidato extends Usuario {

    @Id
    private Long id;

    private String cpf;

    private String cargoDesejado;

    private double pretensaoSalarial;

    private Regiao regiao;

}
