package com.example.BackTecVagas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaForm {

    @NotEmpty(message = "Campo nome não pode estar vazio")
    @Size(min = 2, max = 32, message = "O campo nome deve ter entre 2 e 32 caracteres no maximo")
    private String nomeEmpresa;
    @NotEmpty(message = "Campo cnpj não pode estar vazio")
    @Size(min = 14, max = 14, message = "O campo cnpj deve conter 14 caracteres")
    private String cnpj;
    @NotEmpty(message = "Campo email não pode estar vazio")
    private String email;
    private String telefone;
    @NotEmpty(message = "Campo senha não pode estar vazio")
    private String senha;
}
