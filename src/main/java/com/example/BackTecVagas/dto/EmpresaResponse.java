package com.example.BackTecVagas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponse {

    private String nome; //estava id
    private String nomeEmpresa;
    private String cnpj;
    private String email;
    private String telefone;

}
