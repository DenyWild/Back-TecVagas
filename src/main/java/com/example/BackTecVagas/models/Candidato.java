package com.example.BackTecVagas.models;

import com.example.BackTecVagas.models.enums.Regiao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidato")
public class Candidato extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String cargoDesejado;

    private double pretensaoSalarial;

    @Enumerated(EnumType.STRING)
    private Regiao regiao;

}
