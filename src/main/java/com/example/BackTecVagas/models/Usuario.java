package com.example.BackTecVagas.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long id;
    @NotEmpty(message = "Campo nome não pode estar vazio")
    @Size(min = 3, max = 32, message = "O campo nome deve ter entre 3 e 32 caracteres no maximo")
    private String nome;
    @NotEmpty(message = "Campo email não pode estar vazio")
    private String email;
    private String telefone;
    @NotEmpty(message = "Campo senha não pode estar vazio")
    private String senha;


}
