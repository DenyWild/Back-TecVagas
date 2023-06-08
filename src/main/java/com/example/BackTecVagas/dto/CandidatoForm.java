package com.example.BackTecVagas.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidatoForm {

    @NotEmpty(message = "Campo nome não pode estar vazio")
    @Size(min = 3, max = 32, message = "O campo nome deve ter entre 3 e 32 caracteres no maximo")
    private String nome;
    private String cpf;
    @NotEmpty(message = "Campo email não pode estar vazio")
    private String email;
    @NotEmpty(message = "Campo telefone não pode estar vazio")
    private String telefone;
    @NotEmpty(message = "Campo senha não pode estar vazio")
    private String senha;
    @NotEmpty(message = "Campo Cargo Desejado  não pode estar vazio")
    private String cargoDesejado;
    @NotNull(message = "Campo Pretensao Salarial não pode estar vazio")
    private double pretensaoSalarial;
    @NotNull(message = "Campo estado não pode estar vazio")
    private String estado;

}
