package com.example.BackTecVagas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoAdicionalResponse {

    private Long id;
    private String informacaoAdicional;
}
