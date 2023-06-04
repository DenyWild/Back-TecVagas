package com.example.BackTecVagas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagasForm {


    private String nomeVaga;

    private double salario;

    private String tipoVaga;

    private String nomeEmpresa;
}
