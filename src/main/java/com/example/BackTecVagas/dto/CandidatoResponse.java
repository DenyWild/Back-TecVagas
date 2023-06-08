package com.example.BackTecVagas.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargoDesejado;
    private double pretensaoSalarial;
    private String estado;

}
