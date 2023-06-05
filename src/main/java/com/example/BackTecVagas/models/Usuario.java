package com.example.BackTecVagas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
