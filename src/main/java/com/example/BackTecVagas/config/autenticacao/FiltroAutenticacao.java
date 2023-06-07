package com.example.BackTecVagas.config.autenticacao;

import com.example.BackTecVagas.models.Usuario;
import com.example.BackTecVagas.services.AutenticacaoService;
import com.example.BackTecVagas.services.UsuarioService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class FiltroAutenticacao extends OncePerRequestFilter {

    private AutenticacaoService autenticacaoService;
    private UsuarioService usuarioService;

    public FiltroAutenticacao(AutenticacaoService autenticacaoService, UsuarioService usuarioService) {
        this.autenticacaoService = autenticacaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String token = null;
        if(header != null && header.startsWith("Bearer ")) {
            token = header.substring(7, header.length());
        }

        if(autenticacaoService.verificaToken(token)) {
            Long idUsuario = autenticacaoService.retornarIdUsuario(token);
            Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
            SecurityContextHolder.getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()));
        }

        filterChain.doFilter(request, response);

    }

}
