package com.example.BackTecVagas.dto;

import com.example.BackTecVagas.models.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagasResponse {

    private Long id;

    private String nomeVaga;

    private double salario;

    private String tipoVaga;

    private Empresa empresa;
}
