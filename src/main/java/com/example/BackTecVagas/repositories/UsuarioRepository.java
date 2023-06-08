package com.example.BackTecVagas.repositories;

import com.example.BackTecVagas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT candidato c WHERE c.email  = :email" , nativeQuery = true)
    Optional<Usuario> findByEmail(@Param("email") String email);

}
