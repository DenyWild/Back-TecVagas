package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, Long> {
}
