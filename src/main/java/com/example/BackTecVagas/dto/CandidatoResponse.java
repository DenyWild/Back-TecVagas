package com.example.BackTecVagas.dto;

import com.example.BackTecVagas.models.enums.Regiao;
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
    @Enumerated(EnumType.STRING)
    private Regiao regiao;

}
