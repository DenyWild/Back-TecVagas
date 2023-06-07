package com.example.BackTecVagas.controllers;

import com.example.BackTecVagas.models.AutenticacaoForm;
import com.example.BackTecVagas.models.TokenDTO;
import com.example.BackTecVagas.models.Usuario;
import com.example.BackTecVagas.models.UsuarioDTO;
import com.example.BackTecVagas.services.AutenticacaoService;
import com.example.BackTecVagas.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autenticacao")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;

    public AutenticacaoController(AutenticacaoService autenticacaoService, UsuarioService usuarioService) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm) {

        try {
            return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }
}
